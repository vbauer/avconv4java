package com.avconv4java.option.advacned;

import com.avconv4java.core.AVOptions;
import com.avconv4java.model.AVStreamType;

/**
 * @author Vladislav Bauer
 */

public class AVAdvancedVideoOptions extends AVOptions {

    public static final String FLAG_PIXEL_FORMAT = "-pix_fmt";
    public static final String FLAG_SW_SCALER_FLAGS = "-sws_flags";
    public static final String FLAG_DISCARD_THRESHOLD = "-vdt";
    public static final String FLAG_DUMP_VIDEO_ENCODING_STATISTICS = "-vstats";


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

    // TODO:
    // ‘-rc_override[:stream_specifier] override (output,per-stream)’
    // rate control override for specific intervals

    /**
     * ‘-vstats’
     * Dump video coding statistics to ‘vstats_HHMMSS.log’.
     */
    public AVAdvancedVideoOptions dumpVideoEncodingStatistics() {
        return flags(FLAG_DUMP_VIDEO_ENCODING_STATISTICS);
    }

}
