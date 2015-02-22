package com.github.vbauer.avconv4java.option.advacned;

import com.github.vbauer.avconv4java.core.AVOptions;
import com.github.vbauer.avconv4java.model.AVVideoSyncType;

/**
 * @see <a href="http://libav.org/avconv.html#Advanced-options">Official doc: "5.12 Advanced options"</a>
 *
 * @author Vladislav Bauer
 */

public class AVAdvancedOptions extends AVOptions {

    public static final String FLAG_BENCHMARK = "-benchmark";
    public static final String FLAG_TIME_LIMIT = "-timelimit";
    public static final String FLAG_DUMP = "-dump";
    public static final String FLAG_HEX = "-hex";
    public static final String FLAG_VIDEO_SYNC_METHOD = "-vsync";
    public static final String FLAG_COPY_TIMESTAMPS = "-copyts";
    public static final String FLAG_COPY_TIME_BASE = "-copytb";
    public static final String FLAG_DISCONTINUITY_DELTA_THRESHOLD = "-dts_delta_threshold";
    public static final String FLAG_FILTER_COMPLEX_SCRIPT = "-filter_complex_script";
    public static final String FLAG_SHORTEST = "-shortest";
    public static final String FLAG_MAX_DEMUX_DELAY = "-muxdelay";
    public static final String FLAG_DEMUX_PRELOAD_DELAY = "-muxpreload";
    public static final String FLAG_ACCURATE_SEEK = "-accurate_seek";
    public static final String FLAG_NO_ACCURATE_SEEK = "-noaccurate_seek";


    public static AVAdvancedOptions create() {
        return new AVAdvancedOptions();
    }


    @Override
    public AVAdvancedOptions flags(final Object... flags) {
        return (AVAdvancedOptions) super.flags(flags);
    }

    @Override
    public AVAdvancedOptions builders(final AVOptions... builders) {
        return (AVAdvancedOptions) super.builders(builders);
    }


    /**
     * ‘-benchmark (global)’
     * Show benchmarking information at the end of an encode. Shows CPU time used and maximum memory consumption.
     * Maximum memory consumption is not supported on all systems, it will usually display as 0 if not supported.
     */
    public AVAdvancedOptions benchmark() {
        return flags(FLAG_BENCHMARK);
    }

    /**
     * ‘-timelimit duration (global)’
     * Exit after avconv has been running for duration seconds.
     */
    public AVAdvancedOptions timeLimit(final Long limit) {
        return flags(FLAG_TIME_LIMIT, limit);
    }

    /**
     * ‘-dump (global)’
     * Dump each input packet to stderr.
     */
    public AVAdvancedOptions dump() {
        return flags(FLAG_DUMP);
    }

    /**
     * ‘-hex (global)’
     * When dumping packets, also dump the payload.
     */
    public AVAdvancedOptions hex() {
        return flags(FLAG_HEX);
    }

    /**
     * ‘-vsync parameter’
     * Video sync method.
     */
    public AVAdvancedOptions videoSyncMethod(final AVVideoSyncType videoSyncType) {
        return videoSyncMethod(videoSyncType == null ? null : videoSyncType.getName());
    }

    public AVAdvancedOptions videoSyncMethod(final String videoSyncTypeName) {
        return flags(FLAG_VIDEO_SYNC_METHOD, videoSyncTypeName);
    }

    /**
     * ‘-copyts’
     * Copy timestamps from input to output.
     */
    public AVAdvancedOptions copyTimestamps() {
        return flags(FLAG_COPY_TIMESTAMPS);
    }

    /**
     * ‘-copytb’
     * Copy input stream time base from input to output when stream copying.
     */
    public AVAdvancedOptions copyTimeBase() {
        return flags(FLAG_COPY_TIME_BASE);
    }

    /**
     * ‘-dts_delta_threshold’
     * Timestamp discontinuity delta threshold.
     */
    public AVAdvancedOptions discontinuityDeltaThreshold() {
        return flags(FLAG_DISCONTINUITY_DELTA_THRESHOLD);
    }

    /**
     * ‘-filter_complex_script filename (global)’
     * This option is similar to ‘-filter_complex’, the only difference is that its argument is the name of the file
     * from which a complex filtergraph description is to be read.
     */
    public AVAdvancedOptions filterComplexScript(final String fileName) {
        return flags(FLAG_FILTER_COMPLEX_SCRIPT, fileName);
    }

    /**
     * ‘-shortest (output)’
     * Finish encoding when the shortest input stream ends.
     */
    public AVAdvancedOptions shortest() {
        return flags(FLAG_SHORTEST);
    }

    /**
     * ‘-muxdelay seconds (input)’
     * Set the maximum demux-decode delay.
     */
    public AVAdvancedOptions maxDemuxDelay(final Long seconds) {
        return flags(FLAG_MAX_DEMUX_DELAY, seconds);
    }

    /**
     * ‘-muxpreload seconds (input)’
     * Set the initial demux-decode delay.
     */
    public AVAdvancedOptions demuxPreLoadDelay(final Long seconds) {
        return flags(FLAG_DEMUX_PRELOAD_DELAY, seconds);
    }

    /**
     * ‘-accurate_seek (input)’
     * This option enables or disables accurate seeking in input files with the ‘-ss’ option.
     * It is enabled by default, so seeking is accurate when transcoding. Use ‘-noaccurate_seek’ to disable it,
     * which may be useful e.g. when copying some streams and transcoding the others.
     */
    public AVAdvancedOptions accurateSeek(final boolean accurate) {
        return flags(accurate ? FLAG_ACCURATE_SEEK : FLAG_NO_ACCURATE_SEEK);
    }

}
