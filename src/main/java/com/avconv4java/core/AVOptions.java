package com.avconv4java.core;

import java.util.List;

/**
 * @author Vladislav Bauer
 */

public class AVOptions extends AVGenericOptions {

    private final String outputFile;


    private AVOptions(final String inputFile, final String outputFile) {
        this.outputFile = outputFile;
        inputFile(inputFile);
    }


    public static AVOptions create(final String inputFile, final String outputFile) {
        return new AVOptions(inputFile, outputFile);
    }


    @Override
    public AVOptions flags(final Object... flags) {
        return (AVOptions) super.flags(flags);
    }

    @Override
    public AVOptions builders(final AVGenericOptions... builders) {
        return (AVOptions) super.builders(builders);
    }

    @Override
    public List<String> build() {
        final List<String> result = super.build();
        result.add(outputFile);
        return result;
    }


    public String getOutputFile() {
        return outputFile;
    }


    /**
     * ‘-i filename (input)’
     * input file name
     */
    private AVOptions inputFile(final String filename) {
        return flags("-i", filename);
    }

}
