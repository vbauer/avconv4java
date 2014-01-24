package com.avconv4java.option;

import com.avconv4java.core.AVGenericOptions;
import com.avconv4java.model.AVCodecFlagType;
import com.avconv4java.model.AVDebugInfoType;
import com.avconv4java.model.AVMotionEstimationType;
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
        return strict(strictType == null ? null : strictType.getName());
    }

    public AVCodecOptions strict(final String strictTypeName) {
        return flags("-strict", strictTypeName);
    }

    /**
     * ‘-b[:stream_specifier] integer (output,audio,video)’
     * Set bitrate (in kbits/s).
     */
    public AVCodecOptions bitRate(final Integer bitRate) {
        return flags("-b", kb(bitRate));
    }

    /**
     * ‘-bt[:stream_specifier] integer (output,video)’
     * Set video bitrate tolerance (in kbits/s). In 1-pass mode, bitrate tolerance specifies how far ratecontrol is
     * willing to deviate from the target average bitrate value. This is not related to minimum/maximum bitrate.
     * Lowering tolerance too much has an adverse effect on quality.
     */
    public AVCodecOptions videoBitRateTolerance(final Integer bitRate) {
        return flags("-bt", kb(bitRate));
    }

    /**
     * ‘-me_method[:stream_specifier] integer (output,video)’
     * Set motion estimation method.
     */
    public AVCodecOptions motionEstimationMethod(final AVMotionEstimationType motionEstimationType) {
        return motionEstimationMethod(motionEstimationType == null ? null : motionEstimationType.getName());
    }

    public AVCodecOptions motionEstimationMethod(final String motionEstimationTypeName) {
        return flags("-me_method", motionEstimationTypeName);
    }

    /**
     * ‘-debug[:stream_specifier] flags (input/output,audio,video,subtitles)’
     * Print specific debug info.
     */
    public AVCodecOptions debug(final AVDebugInfoType debugInfoType) {
        return debug(debugInfoType == null ? null : debugInfoType.getName());
    }

    public AVCodecOptions debug(final String debugInfoTypeName) {
        return flags("-debug", debugInfoTypeName);
    }

    /**
     * ‘-flags[:stream_specifier] flags (input/output,audio,video)’
     */
    public AVCodecOptions codecFlags(final AVCodecFlagType flagType) {
        return codecFlags(flagType == null ? null : flagType.getName());
    }

    public AVCodecOptions codecFlags(final String flagTypeName) {
        return flags("-flags", flagTypeName);
    }

}
