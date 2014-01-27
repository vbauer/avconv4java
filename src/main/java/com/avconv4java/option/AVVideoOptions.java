package com.avconv4java.option;

import com.avconv4java.core.AVOptions;
import com.avconv4java.model.AVFileFormatType;
import com.avconv4java.model.AVMovFlagsType;
import com.avconv4java.model.AVStreamType;
import com.avconv4java.model.AVVideoCodecType;
import com.avconv4java.model.AVVideoSizeType;
import com.avconv4java.util.AVUtils;

/**
 * 5.7 Video Options.
 *
 * @author Vladislav Bauer
 */

public class AVVideoOptions extends AVOptions {

    public static final String FLAG_VIDEO_CODEC = "-vcodec";
    public static final String FLAG_RESIZE = "-s";
    public static final String FLAG_FRAME_RATE = "-r";
    public static final String FLAG_FILE_FORMAT = "-f";
    public static final String FLAG_MOV_FLAGS = "-movflags";
    public static final String FLAG_VIDEO_FRAMES_COUNT = "-vframes";
    public static final String FLAG_FILTER = "-vf";

    public static final String FILTER_SCALE_BY_WIDTH = "scale=w=%d:h=trunc(ow/a/2)*2";
    public static final String FILTER_SCALE_BY_HEIGHT = "scale=w=trunc(oh/a/2)*2:h=%d";


    public static AVVideoOptions create() {
        return new AVVideoOptions();
    }


    @Override
    public AVVideoOptions flags(final Object... flags) {
        return (AVVideoOptions) super.flags(flags);
    }

    @Override
    public AVVideoOptions builders(final AVOptions... builders) {
        return (AVVideoOptions) super.builders(builders);
    }


    /**
     * ‘-vcodec codec (output)’
     * Set the video codec. This is an alias for -codec:v.
     */
    public AVVideoOptions videoCodec(final AVVideoCodecType codecType) {
        return videoCodec(codecType == null ? null : codecType.getName());
    }

    public AVVideoOptions videoCodec(final String codecTypeName) {
        return flags(FLAG_VIDEO_CODEC, codecTypeName);
    }

    public AVVideoOptions resize(final AVStreamType streamType, final Integer width, final Integer height) {
        final boolean shouldResize = width != null || height != null;
        final String w = AVUtils.trimToEmpty(even(width));
        final String h = AVUtils.trimToEmpty(even(height));
        final String size = shouldResize ? String.format("%sx%s", w, h) : null;
        return resize(streamType, size);
    }

    public AVVideoOptions resize(final AVStreamType streamType, final AVVideoSizeType videoSizeType) {
        return flags(specifyStream(FLAG_RESIZE, streamType), videoSizeType == null ? null : videoSizeType.getName());
    }

    public AVVideoOptions resize(final AVStreamType streamType, final String size) {
        return flags(specifyStream(FLAG_RESIZE, streamType), size);
    }

    /**
     * ‘-vf filter_graph (output)’
     * filter_graph is a description of the filter graph to apply to the input video.
     * Use the option "-filters" to show all the available filters (including also sources and sinks).
     * This is an alias for -filter:v.
     */
    public AVVideoOptions filter(final String filter, final Object... params) {
        return flags(FLAG_FILTER, format(filter, params));
    }

    public AVVideoOptions proportionalResizeUsingWidth(final Integer width) {
        return filter(FILTER_SCALE_BY_WIDTH, even(width));
    }

    public AVVideoOptions proportionalResizeUsingHeight(final Integer height) {
        return filter(FILTER_SCALE_BY_HEIGHT, even(height));
    }

    public AVVideoOptions frameRate(final Integer rate) {
        return flags(FLAG_FRAME_RATE, rate);
    }

    public AVVideoOptions fileFormat(final AVFileFormatType formatType) {
        return fileFormat(formatType == null ? null : formatType.getName());
    }

    public AVVideoOptions fileFormat(final String formatTypeName) {
        return flags(FLAG_FILE_FORMAT, formatTypeName);
    }

    public AVVideoOptions movFlags(final AVMovFlagsType movFlagsType) {
        return movFlags(movFlagsType == null ? null : movFlagsType.getName());
    }

    public AVVideoOptions movFlags(final String movFlagsTypeName) {
        return flags(FLAG_MOV_FLAGS, movFlagsTypeName);
    }

    /**
     * ‘-vframes number (output)’
     * Set the number of video frames to record. This is an alias for -frames:v.
     */
    public AVVideoOptions videoFramesCount(final Integer frames) {
        return flags(FLAG_VIDEO_FRAMES_COUNT, frames);
    }

}
