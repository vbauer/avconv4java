package com.github.vbauer.avconv4java.option;

import com.github.vbauer.avconv4java.core.AVOptions;
import com.github.vbauer.avconv4java.model.AVAudioCodecType;
import com.github.vbauer.avconv4java.model.AVStreamType;

/**
 * @see <a href="http://libav.org/avconv.html#Audio-Options">Official doc: "5.9 Audio Options"</a>
 *
 * @author Vladislav Bauer
 */

public class AVAudioOptions extends AVOptions {

    public static final String FLAG_AUDIO_FRAMES_COUNT = "-aframes";
    public static final String FLAG_SAMPLE_RATE = "-ar";
    public static final String FLAG_AUDIO_QUALITY = "-aq";
    public static final String FLAG_AUDIO_CHANNELS_COUNT = "-ac";
    public static final String FLAG_DISABLE_AUDIO_RECORDING = "-an";
    public static final String FLAG_AUDIO_CODEC = "-acodec";
    public static final String FLAG_AUDIO_BIT_RATE = "-ab";
    public static final String FLAG_SAMPLE_FORMAT = "-sample_fmt";
    public static final String FLAG_FILTER_GRAPH = "-af";


    public static AVAudioOptions create() {
        return new AVAudioOptions();
    }


    @Override
    public AVAudioOptions flags(final Object... flags) {
        return (AVAudioOptions) super.flags(flags);
    }

    @Override
    public AVAudioOptions builders(final AVOptions... builders) {
        return (AVAudioOptions) super.builders(builders);
    }


    /**
     * ‘-aq q (output)’
     * Set the audio quality (codec-specific, VBR). This is an alias for -q:a.
     */
    public AVAudioOptions audioQuality(final Double quality) {
        return flags(FLAG_AUDIO_QUALITY, format("%.4f", quality));
    }

    /**
     * ‘-acodec codec (input/output)’
     * Set the audio codec. This is an alias for -codec:a.
     */
    public AVAudioOptions audioCodec(final AVAudioCodecType codecType) {
        return audioCodec(codecType == null ? null : codecType.getName());
    }

    public AVAudioOptions audioCodec(final String codecTypeName) {
        return flags(FLAG_AUDIO_CODEC, codecTypeName);
    }

    public AVAudioOptions audioBitRate(final Integer bitRate) {
        return flags(FLAG_AUDIO_BIT_RATE, kb(bitRate));
    }

    /**
     * ‘-an (output)’
     * Disable audio recording.
     */
    public AVAudioOptions disableRecording() {
        return flags(FLAG_DISABLE_AUDIO_RECORDING);
    }

    /**
     * ‘-aframes number (output)’
     * Set the number of audio frames to record. This is an alias for -frames:a.
     */
    public AVAudioOptions framesCount(final Long count) {
        return flags(FLAG_AUDIO_FRAMES_COUNT, count);
    }

    /**
     * ‘-ac[:stream_specifier] channels (input/output,per-stream)’
     * Set the number of audio channels. For output streams it is set by default to the number of input audio channels.
     * For input streams this option only makes sense for audio grabbing devices and raw demuxers and is mapped to the
     * corresponding demuxer options.
     */
    public AVAudioOptions audioChannelsCount(final AVStreamType streamType, final Integer count) {
        return flags(specifyStream(FLAG_AUDIO_CHANNELS_COUNT, streamType), count);
    }

    public AVAudioOptions audioChannelsCount(final Integer count) {
        return audioChannelsCount(null, count);
    }

    /**
     ‘-ar[:stream_specifier] freq (input/output,per-stream)’
     * Set the audio sampling frequency. For output streams it is set by default to the frequency of the corresponding
     * input stream. For input streams this option only makes sense for audio grabbing devices and raw demuxers and is
     * mapped to the corresponding demuxer options.
     */
    public AVAudioOptions sampleRate(final AVStreamType streamType, final Integer sampleRate) {
        return flags(specifyStream(FLAG_SAMPLE_RATE, streamType), sampleRate);
    }

    public AVAudioOptions sampleRate(final Integer sampleRate) {
        return sampleRate(null, sampleRate);
    }

    /**
     * ‘-sample_fmt[:stream_specifier] sample_fmt (output,per-stream)’
     * Set the audio sample format. Use -sample_fmts to get a list of supported sample formats.
     */
    public AVAudioOptions sampleFormat(final AVStreamType streamType, final String format) {
        return flags(specifyStream(FLAG_SAMPLE_FORMAT, streamType), format);
    }

    public AVAudioOptions sampleFormat(final String format) {
        return sampleFormat(null, format);
    }

    /**
     * ‘-af filter_graph (output)’
     * filter_graph is a description of the filter graph to apply to the input audio. Use the option "-filters" to
     * show all the available filters (including also sources and sinks). This is an alias for -filter:a.
     */
    public AVAudioOptions filter(final String filter) {
        return flags(FLAG_FILTER_GRAPH, filter);
    }

}
