package com.avconv4java.option;

import com.avconv4java.core.AVOptions;

/**
 * @author Vladislav Bauer
 */

public class AVFormatOptions extends AVOptions {

    public static final String FLOAG_PROBE_SIZE = "-probesize";

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
        return flags(FLOAG_PROBE_SIZE, size);
    }

}
