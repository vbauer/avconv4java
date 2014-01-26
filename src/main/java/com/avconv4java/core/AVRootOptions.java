package com.avconv4java.core;

import java.util.List;

/**
 * @author Vladislav Bauer
 */

public class AVRootOptions extends AVOptions {

    private final String outputFile;


    private AVRootOptions(final String inputFile, final String outputFile) {
        this.outputFile = outputFile;
        inputFile(inputFile);
    }


    public static AVRootOptions create(final String inputFile, final String outputFile) {
        return new AVRootOptions(inputFile, outputFile);
    }


    @Override
    public AVRootOptions flags(final Object... flags) {
        return (AVRootOptions) super.flags(flags);
    }

    @Override
    public AVRootOptions builders(final AVOptions... builders) {
        return (AVRootOptions) super.builders(builders);
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
    private AVRootOptions inputFile(final String filename) {
        return flags("-i", filename);
    }

}
