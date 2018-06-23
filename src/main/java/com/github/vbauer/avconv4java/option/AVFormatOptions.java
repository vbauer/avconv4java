package com.github.vbauer.avconv4java.option;

import com.github.vbauer.avconv4java.core.AVOptions;
import com.github.vbauer.avconv4java.type.AVErrorDetectionType;
import com.github.vbauer.avconv4java.type.AVFormatDebugInfoType;
import com.github.vbauer.avconv4java.type.AVFormatFlagType;

import java.util.Collection;

/**
 * Format Audio/Video Options.
 * @see <a href="http://libav.org/avconv.html#Format-AVOptions">Official doc: "5.5 Format AVOptions"</a>
 *
 * @author Vladislav Bauer
 */

public class AVFormatOptions extends AVOptions {

    public static final String FLAG_PROBE_SIZE = "-probesize";
    public static final String FLAG_PACKET_SIZE = "-packetsize";
    public static final String FLAG_FORMAT_FLAGS = "-fflags";
    public static final String FLAG_ANALYZE_DURATION = "-analyzeduration";
    public static final String FLAG_DECRYPTION_KEY = "-cryptokey";
    public static final String FLAG_TIMESTAMP_INDEX_SIZE = "-indexmem";
    public static final String FLAG_REAL_TIME_BUFFER_SIZE = "-rtbufsize";
    public static final String FLAG_DEBUG_INFO = "-fdebug";
    public static final String FLAG_MAX_DELAY = "-max_delay";
    public static final String FLAG_FPS_PROBE_SIZE = "-fpsprobesize";
    public static final String FLAG_ERROR_DETECTION = "-err_detect";
    public static final String FLAG_INTERLEAVING_BUFFER_SIZE = "-max_interleave_delta";


    public static AVFormatOptions create() {
        return new AVFormatOptions();
    }


    @Override
    public AVFormatOptions flags(final Collection<Object> flags) {
        return (AVFormatOptions) super.flags(flags);
    }

    @Override
    public AVFormatOptions flags(final Object... flags) {
        return (AVFormatOptions) super.flags(flags);
    }

    @Override
    public AVFormatOptions builders(final Collection<AVOptions> builders) {
        return (AVFormatOptions) super.builders(builders);
    }

    @Override
    public AVFormatOptions builders(final AVOptions... builders) {
        return (AVFormatOptions) super.builders(builders);
    }


    /**
     * Set probing size.
     * CMD: ‘-probesize integer (input)’
     */
    public AVFormatOptions probeSize(final Long size) {
        return flags(FLAG_PROBE_SIZE, size);
    }

    /**
     * Set packet size.
     * CMD: ‘-packetsize integer (output)’
     */
    public AVFormatOptions packetSize(final Long size) {
        return flags(FLAG_PACKET_SIZE, size);
    }

    /**
     * Set format flags.
     * CMD: ‘-fflags flags (input/output)’
     */
    public AVFormatOptions formatFlags(final AVFormatFlagType formatFlagType) {
        return formatFlags(formatFlagType == null ? null : formatFlagType.getName());
    }

    public AVFormatOptions formatFlags(final String formatFlagTypeName) {
        return flags(FLAG_FORMAT_FLAGS, formatFlagTypeName);
    }

    /**
     * How many microseconds are analyzed to estimate duration.
     * CMD: ‘-analyzeduration integer (input)’
     */
    public AVFormatOptions analyzeDuration(final Long duration) {
        return flags(FLAG_ANALYZE_DURATION, duration);
    }

    /**
     * Set decryption key.
     * CMD: ‘-cryptokey hexadecimal string (input)’
     */
    public AVFormatOptions decryptionKey(final String key) {
        return flags(FLAG_DECRYPTION_KEY, key);
    }

    /**
     * Max memory used for timestamp index (per stream).
     * CMD: ‘-indexmem integer (input)’
     */
    public AVFormatOptions timestampIndexSize(final Long maxMemory) {
        return flags(FLAG_TIMESTAMP_INDEX_SIZE, maxMemory);
    }

    /**
     * Max memory used for buffering real-time frames.
     * CMD: ‘-rtbufsize integer (input)’
     */
    public AVFormatOptions realTimeBufferSize(final Long maxMemory) {
        return flags(FLAG_REAL_TIME_BUFFER_SIZE, maxMemory);
    }

    /**
     * Print specific debug info.
     * CMD: ‘-fdebug flags (input/output)’
     */
    public AVFormatOptions debugInfo(final AVFormatDebugInfoType debugInfoType) {
        return debugInfo(debugInfoType == null ? null : debugInfoType.getName());
    }

    public AVFormatOptions debugInfo(final String debugInfoTypeName) {
        return flags(FLAG_DEBUG_INFO, debugInfoTypeName);
    }

    /**
     * Maximum muxing or demuxing delay in microseconds.
     * CMD: ‘-max_delay integer (input/output)’
     */
    public AVFormatOptions maxDelay(final Long delay) {
        return flags(FLAG_MAX_DELAY, delay);
    }

    /**
     * Number of frames used to probe fps.
     * CMD: ‘-fpsprobesize integer (input)’
     */
    public AVFormatOptions fpsProbeSize(final Long size) {
        return flags(FLAG_FPS_PROBE_SIZE, size);
    }

    /**
     * Set error detection flags (deprecated; use err_detect, save via avconv).
     * CMD: ‘-f_err_detect flags (input)’
     */
    public AVFormatOptions errorDetection(final AVErrorDetectionType errorDetectionType) {
        return errorDetection(errorDetectionType == null ? null : errorDetectionType.getName());
    }

    public AVFormatOptions errorDetection(final String errorDetectionTypeName) {
        return flags(FLAG_ERROR_DETECTION, errorDetectionTypeName);
    }

    public AVFormatOptions interleavingBufferSize(final Long size) {
        return flags(FLAG_INTERLEAVING_BUFFER_SIZE, size);
    }

}
