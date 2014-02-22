package com.avconv4java.option;

import com.avconv4java.core.AVOptions;
import com.avconv4java.model.AVFormatDebugInfoType;
import com.avconv4java.model.AVFormatFlagType;

/**
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

    /**
     * ‘-analyzeduration integer (input)’
     * how many microseconds are analyzed to estimate duration
     */
    public AVFormatOptions analyzeDuration(final Long duration) {
        return flags(FLAG_ANALYZE_DURATION, duration);
    }

    /**
     * ‘-cryptokey hexadecimal string (input)’
     * decryption key
     */
    public AVFormatOptions decryptionKey(final String key) {
        return flags(FLAG_DECRYPTION_KEY, key);
    }

    /**
     * ‘-indexmem integer (input)’
     * max memory used for timestamp index (per stream)
     */
    public AVFormatOptions timestampIndexSize(final Long maxMemory) {
        return flags(FLAG_TIMESTAMP_INDEX_SIZE, maxMemory);
    }

    /**
     * ‘-rtbufsize integer (input)’
     * max memory used for buffering real-time frames
     */
    public AVFormatOptions realTimeBufferSize(final Long maxMemory) {
        return flags(FLAG_REAL_TIME_BUFFER_SIZE, maxMemory);
    }

    /**
     * ‘-fdebug flags (input/output)’
     * print specific debug info
     */
    public AVFormatOptions debugInfo(final AVFormatDebugInfoType debugInfoType) {
        return debugInfo(debugInfoType == null ? null : debugInfoType.getName());
    }

    public AVFormatOptions debugInfo(final String debugInfoTypeName) {
        return flags(FLAG_DEBUG_INFO, debugInfoTypeName);
    }

    /**
     * ‘-max_delay integer (input/output)’
     * maximum muxing or demuxing delay in microseconds
     */
    public AVFormatOptions maxDelay(final Long delay) {
        return flags(FLAG_MAX_DELAY, delay);
    }

    /**
     * ‘-fpsprobesize integer (input)’
     * number of frames used to probe fps
     */
    public AVFormatOptions fpsProbeSize(final Long size) {
        return flags(FLAG_FPS_PROBE_SIZE, size);
    }

}
