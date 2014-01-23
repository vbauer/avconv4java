package com.avconv4java.option;

import com.avconv4java.core.AVGenericOptions;

/**
 * @author Vladislav Bauer
 */

public class AVSubtitleOptions extends AVGenericOptions {

    public static AVSubtitleOptions create() {
        return new AVSubtitleOptions();
    }


    @Override
    public AVSubtitleOptions flags(final Object... flags) {
        return (AVSubtitleOptions) super.flags(flags);
    }

    @Override
    public AVSubtitleOptions builders(final AVGenericOptions... builders) {
        return (AVSubtitleOptions) super.builders(builders);
    }


    /**
     * ‘-scodec codec (input/output)’
     * Set the subtitle codec. This is an alias for -codec:s.
     */
    public AVSubtitleOptions subtitleCodec(final String codecName) {
        return flags("-scodec", codecName);
    }

    /**
     * ‘-sn (output)’
     * Disable subtitle recording.
     */
    public AVSubtitleOptions disableSubtitleRecording() {
        return flags("-sn");
    }

}
