package com.github.vbauer.avconv4java.option.advanced;

import com.github.vbauer.avconv4java.core.AVOptions;
import com.github.vbauer.avconv4java.type.AVHardwareAccelerationType;
import com.github.vbauer.avconv4java.type.AVStreamType;

/**
 * @see <a href="http://libav.org/avconv.html#Advanced-Video-Options">Official doc: "5.8 Advanced Video Options"</a>
 *
 * @author Vladislav Bauer
 */

public class AVAdvancedVideoOptions extends AVOptions {

    public static final String FLAG_PIXEL_FORMAT = "-pix_fmt";
    public static final String FLAG_SW_SCALER_FLAGS = "-sws_flags";
    public static final String FLAG_DISCARD_THRESHOLD = "-vdt";
    public static final String FLAG_DUMP_VIDEO_ENCODING_STATISTICS = "-vstats";
    public static final String FLAG_DUMP_VIDEO_ENCODING_STATISTICS_FILE = "-vstats_file";
    public static final String FLAG_HARDWARE_ACCELERATION = "-hwaccel";


    public static AVAdvancedVideoOptions create() {
        return new AVAdvancedVideoOptions();
    }


    @Override
    public AVAdvancedVideoOptions flags(final Object... flags) {
        return (AVAdvancedVideoOptions) super.flags(flags);
    }

    @Override
    public AVAdvancedVideoOptions builders(final AVOptions... builders) {
        return (AVAdvancedVideoOptions) super.builders(builders);
    }


    /**
     * ‘-pix_fmt[:stream_specifier] format (input/output,per-stream)’
     * Set pixel format. Use -pix_fmts to show all the supported pixel formats.
     */
    public AVAdvancedVideoOptions pixelFormat(final AVStreamType streamType, final String format) {
        return flags(specifyStream(FLAG_PIXEL_FORMAT, streamType), format);
    }

    public AVAdvancedVideoOptions pixelFormat(final String format) {
        return pixelFormat(null, format);
    }

    /**
     * ‘-sws_flags flags (input/output)’
     * Set SwScaler flags.
     */
    public AVAdvancedVideoOptions swScalerFlags(final String flags) {
        return flags(FLAG_SW_SCALER_FLAGS, flags);
    }

    /**
     * ‘-vdt n’
     * Discard threshold.
     */
    public AVAdvancedVideoOptions discardThreshold(final Integer threshold) {
        return flags(FLAG_DISCARD_THRESHOLD, threshold);
    }

    /**
     * ‘-vstats’
     * Dump video coding statistics to ‘vstats_HHMMSS.log’.
     */
    public AVAdvancedVideoOptions dumpVideoEncodingStatistics() {
        return flags(FLAG_DUMP_VIDEO_ENCODING_STATISTICS);
    }

    /**
     * ‘-vstats_file file’
     * Dump video coding statistics to file.
     */
    public AVAdvancedVideoOptions dumpVideoEncodingStatistics(final String fileName) {
        return flags(FLAG_DUMP_VIDEO_ENCODING_STATISTICS_FILE, fileName);
    }

    /**
     * ‘-hwaccel[:stream_specifier] hwaccel (input,per-stream)’
     * Use hardware acceleration to decode the matching stream(s).
     *
     * This option has no effect if the selected hwaccel is not available or not supported by the chosen decoder.
     *
     * Note that most acceleration methods are intended for playback and will not be faster than software decoding
     * on modern CPUs. Additionally, avconv will usually need to copy the decoded frames from the GPU memory into
     * the system memory, resulting in further performance loss. This option is thus mainly useful for testing.
     */
    public AVAdvancedVideoOptions hardwareAcceleration(
        final AVStreamType streamType, final AVHardwareAccelerationType accelerationType
    ) {
        final String hardwareAccelerationTypeName = accelerationType.getName();
        return hardwareAcceleration(streamType, hardwareAccelerationTypeName);
    }

    public AVAdvancedVideoOptions hardwareAcceleration(final AVStreamType streamType, final String accelerationType) {
        return flags(specifyStream(FLAG_HARDWARE_ACCELERATION, streamType), accelerationType);
    }

}
