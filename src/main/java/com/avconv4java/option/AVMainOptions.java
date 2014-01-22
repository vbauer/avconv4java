package com.avconv4java.option;

import com.avconv4java.core.AVGenericOptions;

/**
 * @author Vladislav Bauer
 */

public class AVMainOptions extends AVGenericOptions {

    public static AVMainOptions create() {
        return new AVMainOptions();
    }


    @Override
    public AVMainOptions flags(final Object... flags) {
        return (AVMainOptions) super.flags(flags);
    }

    @Override
    public AVMainOptions builders(final AVGenericOptions... builders) {
        return (AVMainOptions) super.builders(builders);
    }


    /**
     * ‘-y (global)’
     * Overwrite output files without asking.
     */
    public AVMainOptions overwriteOutput() {
        return flags("-y");
    }

    /**
     * ‘-n (global)’
     * Immediately exit when output files already exist.
     */
    public AVMainOptions immediatelyExit() {
        return flags("-n");
    }

    /**
     * ‘-t duration (output)’
     * Stop writing the output after its duration reaches duration. duration may be a number in seconds,
     * or in hh:mm:ss[.xxx] form.
     */
    public AVMainOptions duration(final String duration) {
        return flags("-t", duration);
    }

    public AVMainOptions duration(final Long duration) {
        return flags("-t", duration);
    }

    /**
     * ‘-fs limit_size (output)’
     * Set the file size limit.
     */
    public AVMainOptions fileSizeLimit(final Long fileSize) {
        return flags("-fs", fileSize);
    }

    /**
     * ‘-ss position (input/output)’
     * When used as an input option (before -i), seeks in this input file to position.
     * Note the in most formats it is not possible to position exactly, so avconv will position to the closest position point
     * before position. When transcoding and ‘-accurate_seek’ is enabled (the default), this extra segment between
     * the position point and position will be decoded and discarded. When doing stream copy or when ‘-noaccurate_seek’
     * is used, it will be preserved.
     *
     * When used as an output option (before an output filename), decodes but discards input until the timestamps
     * reach position.
     *
     * position may be either in seconds or in hh:mm:ss[.xxx] form.
     */
    public AVMainOptions seek(final String position) {
        return flags("-ss", position);
    }

    public AVMainOptions seek(final Double position) {
        return position == null ? this : flags("-ss", String.format("%.2f", position));
    }

    /**
     * ‘-dframes number (output)’
     * Set the number of data frames to record. This is an alias for -frames:d.
     */
    public AVMainOptions dataFrames(final Long dataFrames) {
        return flags("-dframes", dataFrames);
    }

}
