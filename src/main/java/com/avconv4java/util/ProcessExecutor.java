package com.avconv4java.util;

import java.lang.reflect.Method;
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

public final class ProcessExecutor {

    public static final int EXIT_CODE_ERROR = 1;
    public static final int EXIT_CODE_SUCCESS = 0;


    private static final Logger LOGGER = Logger.getLogger(ProcessExecutor.class.getSimpleName());


    private ProcessExecutor() {
        throw new UnsupportedOperationException();
    }


    public static int execute(
        final List<String> arguments, final Long timeout, final boolean debug
    ) throws Exception {
        final Process process = runProcess(arguments, debug);
        final boolean hasTimeout = timeout != null && timeout > 0;
        return hasTimeout ? waitWithTimeout(process, arguments, timeout) : waitWithoutTimeout(process);
    }


    private static int waitWithoutTimeout(final Process process) throws Exception {
        try {
            return process.waitFor();
        } finally {
            process.destroy();
        }
    }

    private static int waitWithTimeout(
        final Process process, final List<String> arguments, final long timeout
    ) throws Exception {
        final ExecutorService executor = Executors.newSingleThreadExecutor();
        try {
            final Callable<Integer> task = new Callable<Integer>() {
                @Override
                public Integer call() throws Exception {
                    return waitWithoutTimeout(process);
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
        }
    }

    private static Process runProcess(final List<String> arguments, final boolean debug) throws Exception {
        final ProcessBuilder builder = new ProcessBuilder(arguments);
        if (debug) {
            LOGGER.info(AVUtils.join(arguments));

            // Invoke "inheritIO" for Java 7+
            try {
                final Method inheritIO = ProcessBuilder.class.getDeclaredMethod("inheritIO");
                inheritIO.invoke(builder);
            } catch (final Exception ignored) {
                LOGGER.warning("Can't use debug mode. JRE version doesn't support ProcessBuilder.inheritIO");
            }
        }
        return builder.start();
    }

}
