package com.avconv4java.option;

import com.avconv4java.core.AVGenericOptions;
import com.avconv4java.model.AVFileFormatType;
import com.avconv4java.model.AVMovFlagsType;
import com.avconv4java.model.AVVideoCodecType;

/**
 * 5.7 Video Options.
 *
 * @author Vladislav Bauer
 */

public class AVVideoOptions extends AVGenericOptions {

    public static AVVideoOptions create() {
        return new AVVideoOptions();
    }


    @Override
    public AVVideoOptions flags(final Object... flags) {
        return (AVVideoOptions) super.flags(flags);
    }

    @Override
    public AVVideoOptions builders(final AVGenericOptions... builders) {
        return (AVVideoOptions) super.builders(builders);
    }


    /**
     * ‘-vcodec codec (output)’
     * Set the video codec. This is an alias for -codec:v.
     */
    public AVVideoOptions videoCodec(final AVVideoCodecType codecType) {
        return flags("-vcodec", codecType.getName());
    }

    public AVVideoOptions resize(final Integer width, final Integer height) {
        final StringBuilder size = new StringBuilder();
        if (width != null) {
            size.append(String.valueOf(width));
        }
        size.append("x");
        if (height != null) {
            size.append(String.valueOf(height));
        }
        return flags("-s:v", size);
    }

    /**
     * ‘-vf filter_graph (output)’
     * filter_graph is a description of the filter graph to apply to the input video.
     * Use the option "-filters" to show all the available filters (including also sources and sinks).
     * This is an alias for -filter:v.
     */
    public AVVideoOptions filter(final String filter) {
        return flags("-vf", String.format("%s", filter));
    }

    public AVVideoOptions proportionalResizeUsingWidth(final Integer width) {
        return filter(String.format("scale=w=trunc(%d/2)*2:h=trunc(ow/a/2)*2", width));
    }

    public AVVideoOptions frameRate(final Integer rate) {
        return flags("-r", rate);
    }

    public AVVideoOptions fileFormat(final AVFileFormatType formatType) {
        return flags("-f", formatType.getName());
    }

    public AVVideoOptions movFlags(final AVMovFlagsType movFlagsType) {
        return flags("-movflags", movFlagsType.getName());
    }

    /**
     * ‘-vframes number (output)’
     * Set the number of video frames to record. This is an alias for -frames:v.
     */
    public AVVideoOptions videoFramesCount(final int frames) {
        return flags("-vframes", frames);
    }

}
