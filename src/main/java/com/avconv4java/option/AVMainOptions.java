package com.avconv4java.option;

import com.avconv4java.core.AVGenericOptions;

/**
 * @author Vladislav Bauer
 */

public class AVMainOptions extends AVGenericOptions {

    public static final String FLAG_OVERWRITE_OUTPUT = "-y";
    public static final String FLAG_IMMEDIATELY_EXIT = "-n";
    public static final String FLAG_DURATION = "-t";
    public static final String FLAG_FILE_SIZE_LIMIT = "-fs";
    public static final String FLAG_SEEK = "-ss";
    public static final String FLAG_INPUT_TIME_OFFSET = "-itsoffset";
    public static final String FLAG_DATA_FRAMES = "-dframes";


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
        return flags(FLAG_OVERWRITE_OUTPUT);
    }

    /**
     * ‘-n (global)’
     * Immediately exit when output files already exist.
     */
    public AVMainOptions immediatelyExit() {
        return flags(FLAG_IMMEDIATELY_EXIT);
    }

    /**
     * ‘-t duration (output)’
     * Stop writing the output after its duration reaches duration. duration may be a number in seconds,
     * or in hh:mm:ss[.xxx] form.
     */
    public AVMainOptions duration(final String duration) {
        return flags(FLAG_DURATION, duration);
    }

    public AVMainOptions duration(final Long duration) {
        return flags(FLAG_DURATION, duration);
    }

    /**
     * ‘-fs limit_size (output)’
     * Set the file size limit.
     */
    public AVMainOptions fileSizeLimit(final Long fileSize) {
        return flags(FLAG_FILE_SIZE_LIMIT, fileSize);
    }

    /**
     * ‘-ss position (input/output)’
     * When used as an input option (before -i), seeks in this input file to position.
     * Note the in most formats it is not possible to position exactly, so avconv will position to the closest position
     * point before position. When transcoding and ‘-accurate_seek’ is enabled (the default), this extra segment
     * between the position point and position will be decoded and discarded. When doing stream copy or when
     * ‘-noaccurate_seek’ is used, it will be preserved.
     *
     * When used as an output option (before an output filename), decodes but discards input until the timestamps
     * reach position.
     *
     * position may be either in seconds or in hh:mm:ss[.xxx] form.
     */
    public AVMainOptions seek(final String position) {
        return flags(FLAG_SEEK, position);
    }

    public AVMainOptions seek(final Double position) {
        return seek(sec(position));
    }

    /**
     * ‘-itsoffset offset (input)’
     * Set the input time offset in seconds. [-]hh:mm:ss[.xxx] syntax is also supported. The offset is added to the
     * timestamps of the input files. Specifying a positive offset means that the corresponding streams are delayed by
     * offset seconds.
     */
    public AVMainOptions inputTimeOffset(final String position) {
        return flags(FLAG_INPUT_TIME_OFFSET, position);
    }

    public AVMainOptions inputTimeOffset(final Double position) {
        return inputTimeOffset(sec(position));
    }

    /**
     * ‘-dframes number (output)’
     * Set the number of data frames to record. This is an alias for -frames:d.
     */
    public AVMainOptions dataFrames(final Long dataFrames) {
        return flags(FLAG_DATA_FRAMES, dataFrames);
    }

}
