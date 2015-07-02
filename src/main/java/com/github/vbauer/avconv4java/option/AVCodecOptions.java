package com.github.vbauer.avconv4java.option;

import com.github.vbauer.avconv4java.core.AVOptions;
import com.github.vbauer.avconv4java.type.AVCodecFlagType;
import com.github.vbauer.avconv4java.type.AVDebugInfoType;
import com.github.vbauer.avconv4java.type.AVMotionEstimationType;
import com.github.vbauer.avconv4java.type.AVStreamType;
import com.github.vbauer.avconv4java.type.AVStrictType;

import java.util.Collection;

/**
 * @see <a href="http://libav.org/avconv.html#Codec-AVOptions">Official doc: "5.4 Codec AVOptions"</a>
 *
 * @author Vladislav Bauer
 */

public class AVCodecOptions extends AVOptions {

    public static final String FLAG_BIT_RATE = "-b";
    public static final String FLAG_VIDEO_BIT_RATE_TOLERANCE = "-bt";
    public static final String FLAG_CODEC_FLAGS = "-flags";
    public static final String FLAG_MOTION_ESTIMATION_METHOD = "-me_method";
    public static final String FLAG_GROUP_OF_PICTURES = "-g";
    public static final String FLAG_CUT_OFF_BANDWIDTH = "-cutoff";
    public static final String FLAG_FRAME_SIZE = "-frame_size";
    public static final String FLAG_STRICT = "-strict";
    public static final String FLAG_DEBUG = "-debug";
    public static final String FLAG_PRESET = "-pre";


    public static AVCodecOptions create() {
        return new AVCodecOptions();
    }


    @Override
    public AVCodecOptions flags(final Collection<Object> flags) {
        return (AVCodecOptions) super.flags(flags);
    }

    @Override
    public AVCodecOptions flags(final Object... flags) {
        return (AVCodecOptions) super.flags(flags);
    }

    @Override
    public AVCodecOptions builders(final Collection<AVOptions> builders) {
        return (AVCodecOptions) super.builders(builders);
    }

    @Override
    public AVCodecOptions builders(final AVOptions... builders) {
        return (AVCodecOptions) super.builders(builders);
    }


    public AVCodecOptions strict(final AVStrictType strictType) {
        return strict(strictType == null ? null : strictType.getName());
    }

    public AVCodecOptions strict(final String strictTypeName) {
        return flags(FLAG_STRICT, strictTypeName);
    }

    /**
     * ‘-b[:stream_specifier] integer (output,audio,video)’
     * Set bitrate (in kbits/s).
     */
    public AVCodecOptions bitRate(final AVStreamType streamType, final Integer bitRate) {
        return flags(specifyStream(FLAG_BIT_RATE, streamType), kb(bitRate));
    }

    public AVCodecOptions bitRate(final Integer bitRate) {
        return bitRate(null, bitRate);
    }

    /**
     * ‘-bt[:stream_specifier] integer (output,video)’
     * Set video bitrate tolerance (in kbits/s). In 1-pass mode, bitrate tolerance specifies how far ratecontrol is
     * willing to deviate from the target average bitrate value. This is not related to minimum/maximum bitrate.
     * Lowering tolerance too much has an adverse effect on quality.
     */
    public AVCodecOptions videoBitRateTolerance(final AVStreamType streamType, final Integer bitRate) {
        return flags(specifyStream(FLAG_VIDEO_BIT_RATE_TOLERANCE, streamType), kb(bitRate));
    }

    public AVCodecOptions videoBitRateTolerance(final Integer bitRate) {
        return videoBitRateTolerance(null, bitRate);
    }

    /**
     * ‘-me_method[:stream_specifier] integer (output,video)’
     * Set motion estimation method.
     */
    public AVCodecOptions motionEstimationMethod(
        final AVStreamType streamType, final AVMotionEstimationType motionEstimationType
    ) {
        final String motionEstimationTypeName = motionEstimationType == null ? null : motionEstimationType.getName();
        return motionEstimationMethod(streamType, motionEstimationTypeName);
    }

    public AVCodecOptions motionEstimationMethod(final AVMotionEstimationType motionEstimationType) {
        return motionEstimationMethod(null, motionEstimationType);
    }

    public AVCodecOptions motionEstimationMethod(final AVStreamType streamType, final String motionEstimationType) {
        return flags(specifyStream(FLAG_MOTION_ESTIMATION_METHOD, streamType), motionEstimationType);
    }

    public AVCodecOptions motionEstimationMethod(final String motionEstimationType) {
        return motionEstimationMethod(null, motionEstimationType);
    }

    /**
     * ‘-debug[:stream_specifier] flags (input/output,audio,video,subtitles)’
     * Print specific debug info.
     */
    public AVCodecOptions debug(final AVDebugInfoType debugInfoType) {
        return debug(debugInfoType == null ? null : debugInfoType.getName());
    }

    public AVCodecOptions debug(final String debugInfoTypeName) {
        return flags(FLAG_DEBUG, debugInfoTypeName);
    }

    /**
     * ‘-flags[:stream_specifier] flags (input/output,audio,video)’
     */
    public AVCodecOptions codecFlags(final AVStreamType streamType, final AVCodecFlagType flagType) {
        return codecFlags(streamType, flagType == null ? null : flagType.getName());
    }

    public AVCodecOptions codecFlags(final AVCodecFlagType flagType) {
        return codecFlags(null, flagType);
    }

    public AVCodecOptions codecFlags(final AVStreamType streamType, final String flagTypeName) {
        return flags(specifyStream(FLAG_CODEC_FLAGS, streamType), flagTypeName);
    }

    public AVCodecOptions codecFlags(final String flagTypeName) {
        return codecFlags(null, flagTypeName);
    }

    /**
     * ‘-g[:stream_specifier] integer (output,video)’
     * set the group of picture (GOP) size
     */
    public AVCodecOptions groupOfPictures(final AVStreamType streamType, final Integer gopSize) {
        return flags(specifyStream(FLAG_GROUP_OF_PICTURES, streamType), gopSize);
    }

    public AVCodecOptions groupOfPictures(final Integer gopSize) {
        return groupOfPictures(null, gopSize);
    }

    /**
     * ‘-cutoff[:stream_specifier] integer (output,audio)’
     * set cutoff bandwidth
     */
    public AVCodecOptions cutOffBandwidth(final AVStreamType streamType, final Integer bandwidth) {
        return flags(specifyStream(FLAG_CUT_OFF_BANDWIDTH, streamType), bandwidth);
    }

    public AVCodecOptions cutOffBandwidth(final Integer bandwidth) {
        return cutOffBandwidth(null, bandwidth);
    }

    public AVCodecOptions frameSize(final AVStreamType streamType, final Integer size) {
        return flags(specifyStream(FLAG_FRAME_SIZE, streamType), size);
    }

    public AVCodecOptions frameSize(final Integer size) {
        return frameSize(null, size);
    }

    public AVCodecOptions preset(final AVStreamType streamType, final String fileName) {
        return flags(specifyStream(FLAG_PRESET, streamType), fileName);
    }

}
