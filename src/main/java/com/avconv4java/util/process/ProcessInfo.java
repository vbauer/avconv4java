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
        final ProcessInfo result = new ProcessInfo();
        result.setStatusCode(statusCode);
        result.setOutput(output);
        result.setErrorOutput(errorOutput);
        return result;
    }


    public int getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(final int statusCode) {
        this.statusCode = statusCode;
    }

    public String getOutput() {
        return output;
    }

    public void setOutput(final String output) {
        this.output = output;
    }

    public String getErrorOutput() {
        return errorOutput;
    }

    public void setErrorOutput(final String errorOutput) {
        this.errorOutput = errorOutput;
    }

    public boolean isSuccess() {
        return getStatusCode() == EXIT_CODE_SUCCESS && AVUtils.isBlank(getErrorOutput());
    }

    public boolean isError() {
        return !isSuccess();
    }

}
