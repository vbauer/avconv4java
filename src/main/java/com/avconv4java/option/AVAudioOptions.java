package com.avconv4java.option;

import com.avconv4java.core.AVGenericOptions;
import com.avconv4java.model.AVAudioCodecType;

/**
 * 5.9 Audio Options.
 *
 * @author Vladislav Bauer
 */

public class AVAudioOptions extends AVGenericOptions {


    public static AVAudioOptions create() {
        return new AVAudioOptions();
    }


    @Override
    public AVAudioOptions flags(final Object... flags) {
        return (AVAudioOptions) super.flags(flags);
    }

    @Override
    public AVAudioOptions builders(final AVGenericOptions... builders) {
        return (AVAudioOptions) super.builders(builders);
    }


    /**
     * ‘-aq q (output)’
     * Set the audio quality (codec-specific, VBR). This is an alias for -q:a.
     */
    public AVAudioOptions audioFreq(final int freq) {
        return flags("-aq", freq);
    }

    /**
     * ‘-acodec codec (input/output)’
     * Set the audio codec. This is an alias for -codec:a.
     */
    public AVAudioOptions audioCodec(final AVAudioCodecType codecType) {
        return flags("-acodec", codecType.getName());
    }

    public AVAudioOptions audioBitRate(final int bitRate) {
        return flags("-ab", bitRate + "k");
    }

}
