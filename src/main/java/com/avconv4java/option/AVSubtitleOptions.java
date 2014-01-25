package com.avconv4java.option;

import com.avconv4java.core.AVGenericOptions;

/**
 * @author Vladislav Bauer
 */

public class AVSubtitleOptions extends AVGenericOptions {

    public static final String FLAG_SUBTITLE_CODEC = "-scodec";
    public static final String FLAG_DISABLE_SUBTITLE_RECORDING = "-sn";


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
        return flags(FLAG_SUBTITLE_CODEC, codecName);
    }

    /**
     * ‘-sn (output)’
     * Disable subtitle recording.
     */
    public AVSubtitleOptions disableSubtitleRecording() {
        return flags(FLAG_DISABLE_SUBTITLE_RECORDING);
    }

}
