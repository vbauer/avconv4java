package com.avconv4java.option;

import com.avconv4java.core.AVOptions;
import com.avconv4java.model.AVFormatFlagType;

/**
 * @author Vladislav Bauer
 */

public class AVFormatOptions extends AVOptions {

    public static final String FLAG_PROBE_SIZE = "-probesize";
    public static final String FLAG_PACKET_SIZE = "-packetsize";
    public static final String FLAG_FORMAT_FLAGS = "-fflags";


    public static AVFormatOptions create() {
        return new AVFormatOptions();
    }


    @Override
    public AVFormatOptions flags(final Object... flags) {
        return (AVFormatOptions) super.flags(flags);
    }

    @Override
    public AVFormatOptions builders(final AVOptions... builders) {
        return (AVFormatOptions) super.builders(builders);
    }


    /**
     * ‘-probesize integer (input)’
     * set probing size
     */
    public AVFormatOptions probeSize(final Long size) {
        return flags(FLAG_PROBE_SIZE, size);
    }

    /**
     * ‘-packetsize integer (output)’
     * set packet size
     */
    public AVFormatOptions packetSize(final Long size) {
        return flags(FLAG_PACKET_SIZE, size);
    }

    /**
     * ‘-fflags flags (input/output)’
     */
    public AVFormatOptions formatFlags(final AVFormatFlagType formatFlagType) {
        return formatFlags(formatFlagType == null ? null : formatFlagType.getName());
    }

    public AVFormatOptions formatFlags(final String formatFlagTypeName) {
        return flags(FLAG_FORMAT_FLAGS, formatFlagTypeName);
    }

}
