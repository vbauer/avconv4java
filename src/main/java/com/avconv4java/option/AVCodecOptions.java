package com.avconv4java.option;

import com.avconv4java.core.AVGenericOptions;
import com.avconv4java.model.AVStrictType;

/**
 * @author Vladislav Bauer
 */

public class AVCodecOptions extends AVGenericOptions {

    public static AVCodecOptions create() {
        return new AVCodecOptions();
    }


    @Override
    public AVCodecOptions flags(final Object... flags) {
        return (AVCodecOptions) super.flags(flags);
    }

    @Override
    public AVCodecOptions builders(final AVGenericOptions... builders) {
        return (AVCodecOptions) super.builders(builders);
    }


    public AVCodecOptions strict(final AVStrictType strictType) {
        return flags("-strict", strictType.getName());
    }

    /**
     * ‘-ac[:stream_specifier] channels (input/output,per-stream)’
     * Set the number of audio channels. For output streams it is set by default to the number of input audio channels.
     * For input streams this option only makes sense for audio grabbing devices and raw demuxers and is mapped to the
     * corresponding demuxer options.
     */
    public AVCodecOptions audioChannelsCount(final int count) {
        return flags("-ac", count);
    }

    public AVCodecOptions videoBitRate(final int bitRate) {
        return flags("-b", bitRate + "k");
    }

    public AVCodecOptions sampleRate(final int sampleRate) {
        return flags("-ar", sampleRate);
    }

}
