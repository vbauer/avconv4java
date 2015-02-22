package com.github.vbauer.avconv4java.option;

import com.github.vbauer.avconv4java.core.AVOptions;
import com.github.vbauer.avconv4java.model.AVLogLevelType;

/**
 * @see <a href="http://libav.org/avconv.html#Generic-options">Official doc: "5.2 Generic options"</a>
 *
 * @author Vladislav Bauer
 */

public class AVGenericOptions extends AVOptions {

    public static final String FLAG_LOG_LEVEL = "-loglevel";
    public static final String FLAG_CPU_FLAGS = "-cpuflags";
    public static final String FLAG_SHOW_LICENSE = "-L";


    public static AVGenericOptions create() {
        return new AVGenericOptions();
    }


    @Override
    public AVGenericOptions flags(final Object... flags) {
        return (AVGenericOptions) super.flags(flags);
    }

    @Override
    public AVGenericOptions builders(final AVOptions... builders) {
        return (AVGenericOptions) super.builders(builders);
    }


    public AVGenericOptions logLevel(final Integer level) {
        return logLevel(level == null ? null : String.valueOf(level));
    }

    public AVGenericOptions logLevel(final AVLogLevelType logLevelType) {
        return logLevel(logLevelType == null ? null : logLevelType.getName());
    }

    public AVGenericOptions logLevel(final String logLevelName) {
        return flags(FLAG_LOG_LEVEL, logLevelName);
    }

    public AVGenericOptions cpuFlags(final String mask) {
        return flags(FLAG_CPU_FLAGS, mask);
    }

    public AVGenericOptions showLicense() {
        return flags(FLAG_SHOW_LICENSE);
    }

}
