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
    public AVAudioOptions audioQuality(final int quality) {
        return flags("-aq", quality);
    }

    /**
     * ‘-acodec codec (input/output)’
     * Set the audio codec. This is an alias for -codec:a.
     */
    public AVAudioOptions audioCodec(final AVAudioCodecType codecType) {
        return audioCodec(codecType == null ? null : codecType.getName());
    }

    public AVAudioOptions audioCodec(final String codecTypeName) {
        return flags("-acodec", codecTypeName);
    }

    public AVAudioOptions audioBitRate(final int bitRate) {
        return flags("-ab", bitRate + "k");
    }

    /**
     * ‘-an (output)’
     * Disable audio recording.
     */
    public AVAudioOptions disableAudioRecording() {
        return flags("-an");
    }

    /**
     * ‘-aframes number (output)’
     * Set the number of audio frames to record. This is an alias for -frames:a.
     */
    public AVAudioOptions audioFramesCount(final Long count) {
        return flags("-aframes", count);
    }

    /**
     * ‘-ac[:stream_specifier] channels (input/output,per-stream)’
     * Set the number of audio channels. For output streams it is set by default to the number of input audio channels.
     * For input streams this option only makes sense for audio grabbing devices and raw demuxers and is mapped to the
     * corresponding demuxer options.
     */
    public AVAudioOptions audioChannelsCount(final Integer count) {
        return flags("-ac", count);
    }

    /**
     ‘-ar[:stream_specifier] freq (input/output,per-stream)’
     * Set the audio sampling frequency. For output streams it is set by default to the frequency of the corresponding
     * input stream. For input streams this option only makes sense for audio grabbing devices and raw demuxers and is
     * mapped to the corresponding demuxer options.
     */
    public AVAudioOptions sampleRate(final Integer sampleRate) {
        return flags("-ar", sampleRate);
    }

}
