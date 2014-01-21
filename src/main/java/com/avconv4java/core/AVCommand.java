package com.avconv4java.core;

import com.avconv4java.util.AVTextUtils;

import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.logging.Logger;

/**
 * @author Vladislav Bauer
 */

public class AVCommand {

    public static final String DEFAULT_PATH = "/usr/bin/avconv";
    public static final int EXIT_CODE_ERROR = 1;

    private static final Logger LOGGER = Logger.getLogger(AVCommand.class.getSimpleName());
    private static String toolPath = DEFAULT_PATH;

    private boolean debug;
    private Long timeout;


    public static void setGlobalSearchPath(final String toolPath) {
        AVCommand.toolPath = toolPath;
    }


    public int run(final AVOptions operation) throws Exception {
        final List<String> arguments = prepareArguments(operation);
        final Process process = startProcess(arguments);
        final Long timeout = getTimeout();

        if (timeout != null && timeout > 0) {
            return runWithTimeout(process, arguments, timeout);
        } else {
            return runWithoutTimeout(process);
        }
    }


    public boolean isDebug() {
        return debug;
    }

    public AVCommand setDebug(final Boolean debug) {
        this.debug = Boolean.TRUE.equals(debug);
        return this;
    }

    public Long getTimeout() {
        return timeout;
    }

    public AVCommand setTimeout(final Long timeout) {
        this.timeout = timeout;
        return this;
    }


    protected int runWithoutTimeout(final Process process) throws Exception {
        try {
            return process.waitFor();
        } finally {
            process.destroy();
        }
    }

    protected int runWithTimeout(
        final Process process, final List<String> arguments, final long timeout
    ) throws Exception {
        final ExecutorService executor = Executors.newSingleThreadExecutor();

        try {
            final Callable<Integer> task = new Callable<Integer>() {
                @Override
                public Integer call() throws Exception {
                    return process.waitFor();
                }
            };
            final Future<Integer> future = executor.submit(task);
            return future.get(timeout, TimeUnit.MILLISECONDS);
        } catch (final TimeoutException ignored) {
            LOGGER.severe("Video converter will be killed by timeout. " + arguments);
            return EXIT_CODE_ERROR;
        } finally {
            try {
                executor.shutdownNow();
            } catch (final Exception ex) {
                LOGGER.severe("Can't shutdown video converter watchdog service");
            }
            process.destroy();
        }
    }

    private Process startProcess(final List<String> pArgs) throws Exception {
        final ProcessBuilder builder = new ProcessBuilder(pArgs);
        if (isDebug()) {
            LOGGER.info(AVTextUtils.join(pArgs));
            builder.inheritIO();
        }
        return builder.start();
    }

    private List<String> prepareArguments(final AVOptions operation) throws Exception {
        final List<String> parameters = new LinkedList<String>();
        parameters.add(AVCommand.toolPath);
        parameters.addAll(operation.build());
        return parameters;
    }

}
