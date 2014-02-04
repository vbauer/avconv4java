package com.avconv4java.util.process;

/**
 * @author Vladislav Bauer
 */

public class ProcessInfo {

    private int statusCode;
    private String output;


    public static ProcessInfo create(final int statusCode, final String output) {
        final ProcessInfo result = new ProcessInfo();
        result.setStatusCode(statusCode);
        result.setOutput(output);
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

}
