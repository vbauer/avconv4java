package com.github.vbauer.avconv4java.util.process;

import com.github.vbauer.avconv4java.util.AVUtils;

import java.util.List;
import java.util.concurrent.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Process executor allows to run new OS application in separate process.
 *
 * @author Vladislav Bauer
 */

public final class ProcessExecutor {

    private static final Logger LOGGER = Logger.getLogger(ProcessExecutor.class.getSimpleName());


    private ProcessExecutor() {
        throw new UnsupportedOperationException();
    }


    public static ProcessInfo execute(
        final List<String> arguments, final Long timeout, final boolean debug
    ) throws Exception {
        final Process process = runProcess(arguments, debug);
        final boolean hasTimeout = timeout != null && timeout > 0;
        return hasTimeout ? waitWithTimeout(process, timeout) : waitWithoutTimeout(process);
    }


    private static ProcessInfo waitWithoutTimeout(final Process process) throws Exception {
        try {
            final int statusCode = process.waitFor();
            final String output = AVUtils.readFully(process.getInputStream());
            final String errorOutput = AVUtils.readFully(process.getErrorStream());
            return ProcessInfo.create(statusCode, output, errorOutput);
        } finally {
            process.destroy();
        }
    }

    private static ProcessInfo waitWithTimeout(final Process process, final long timeout) throws Exception {
        final ExecutorService executor = Executors.newSingleThreadExecutor();
        try {
            final Future<ProcessInfo> future = executor.submit(() -> waitWithoutTimeout(process));
            return future.get(timeout, TimeUnit.MILLISECONDS);
        } catch (final TimeoutException ex) {
            return ProcessInfo.error(ex.getMessage());
        } finally {
            shutdownExecutor(executor);
        }
    }

    private static void shutdownExecutor(final ExecutorService executor) {
        try {
            executor.shutdownNow();
            LOGGER.fine("Command was killed by timeout.");
        } catch (final Exception ex) {
            if (LOGGER.isLoggable(Level.SEVERE)) {
                LOGGER.severe("Can't shutdown executor's watchdog service: " + ex.getMessage());
            }
        }
    }

    private static Process runProcess(final List<String> arguments, final boolean debug) throws Exception {
        final ProcessBuilder builder = new ProcessBuilder(arguments);
        if (debug) {
            LOGGER.info(AVUtils.join(arguments));
            builder.inheritIO();
        }
        return builder.start();
    }

}
