package com.avconv4java.core;

import com.avconv4java.util.process.ProcessExecutor;
import com.avconv4java.util.process.ProcessInfo;

import java.util.LinkedList;
import java.util.List;

/**
 * @author Vladislav Bauer
 */

public class AVCommand {

    public static final String DEFAULT_PATH = "/usr/bin/avconv";

    private static String globalToolPath = DEFAULT_PATH;

    private boolean debug;
    private String toolPath;
    private Long timeout;


    public static void setGlobalToolPath(final String toolPath) {
        AVCommand.globalToolPath = toolPath;
    }


    public ProcessInfo run(final AVOptions operation) throws Exception {
        final List<String> flags = operation.build();
        return run(flags);
    }

    public ProcessInfo run(final List<String> flags) throws Exception {
        final List<String> arguments = prepareArguments(flags);
        return ProcessExecutor.execute(arguments, getTimeout(), isDebug());
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

    public String getToolPath() {
        return toolPath;
    }

    public void setToolPath(final String toolPath) {
        this.toolPath = toolPath;
    }


    private List<String> prepareArguments(final List<String> flags) {
        final String path = toolPath == null ? AVCommand.globalToolPath : toolPath;
        final List<String> parameters = new LinkedList<String>();

        parameters.add(path);
        if (flags != null) {
            parameters.addAll(flags);
        }
        return parameters;
    }

}
