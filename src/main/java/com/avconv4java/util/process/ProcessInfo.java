package com.avconv4java.util.process;

import com.avconv4java.util.AVUtils;

/**
 * Process info that was returned as result.
 *
 * @author Vladislav Bauer
 */

public class ProcessInfo {

    public static final int EXIT_CODE_ERROR = 1;
    public static final int EXIT_CODE_SUCCESS = 0;


    private int statusCode;
    private String output;
    private String errorOutput;


    public static ProcessInfo error(final String errorOutput) {
        return create(EXIT_CODE_ERROR, null, errorOutput);
    }

    public static ProcessInfo create(final int statusCode, final String output, final String errorOutput) {
        return new ProcessInfo()
            .setStatusCode(statusCode)
            .setOutput(output)
            .setErrorOutput(errorOutput);
    }


    public int getStatusCode() {
        return statusCode;
    }

    public ProcessInfo setStatusCode(final int statusCode) {
        this.statusCode = statusCode;
        return this;
    }

    public String getOutput() {
        return output;
    }

    public ProcessInfo setOutput(final String output) {
        this.output = output;
        return this;
    }

    public String getErrorOutput() {
        return errorOutput;
    }

    public ProcessInfo setErrorOutput(final String errorOutput) {
        this.errorOutput = errorOutput;
        return this;
    }

    public boolean isSuccess() {
        return getStatusCode() == EXIT_CODE_SUCCESS && AVUtils.isBlank(getErrorOutput());
    }

    public boolean isError() {
        return !isSuccess();
    }

}
