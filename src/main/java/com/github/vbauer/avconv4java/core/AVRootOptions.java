package com.github.vbauer.avconv4java.core;

import java.util.Collection;
import java.util.List;

/**
 * Root options. All other options should be use as part of it.
 *
 * @author Vladislav Bauer
 */

public class AVRootOptions extends AVOptions {

    public static final String FLAG_INPUT_FILE = "-i";


    private final String outputFile;


    public AVRootOptions(final String inputFile, final String outputFile) {
        this.outputFile = outputFile;
        inputFile(inputFile);
    }


    public static AVRootOptions create(final String inputFile, final String outputFile) {
        return new AVRootOptions(inputFile, outputFile);
    }


    @Override
    public AVRootOptions flags(final Collection<Object> flags) {
        return (AVRootOptions) super.flags(flags);
    }

    @Override
    public AVRootOptions flags(final Object... flags) {
        return (AVRootOptions) super.flags(flags);
    }

    @Override
    public AVRootOptions builders(final Collection<AVOptions> builders) {
        return (AVRootOptions) super.builders(builders);
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
     * An input file name.
     * CMD: ‘-i filename (input)’
     */
    private void inputFile(final String filename) {
        flags(FLAG_INPUT_FILE, filename);
    }

}
