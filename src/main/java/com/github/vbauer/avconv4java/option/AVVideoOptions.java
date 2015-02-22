package com.github.vbauer.avconv4java.option;

import com.github.vbauer.avconv4java.core.AVOptions;
import com.github.vbauer.avconv4java.model.AVMovFlagsType;
import com.github.vbauer.avconv4java.model.AVStreamType;
import com.github.vbauer.avconv4java.model.AVVideoCodecType;
import com.github.vbauer.avconv4java.model.AVVideoSizeType;
import com.github.vbauer.avconv4java.util.AVUtils;

/**
 * @see <a href="http://libav.org/avconv.html#Video-Options">Official doc: "5.7 Video Options"</a>
 *
 * @author Vladislav Bauer
 */

public class AVVideoOptions extends AVOptions {

    public static final String FLAG_VIDEO_FRAMES_COUNT = "-vframes";
    public static final String FLAG_FRAME_RATE = "-r";
    public static final String FLAG_RESIZE = "-s";
    public static final String FLAG_ASPECT_RATIO = "-aspect";
    public static final String FLAG_DISABLE_VIDEO_RECORDING = "-vn";
    public static final String FLAG_VIDEO_CODEC = "-vcodec";
    public static final String FLAG_MOV_FLAGS = "-movflags";
    public static final String FLAG_PASS_COUNT = "-pass";
    public static final String FLAG_PASS_LOG_FILE_PREFIX = "-passlogfile";
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

    /**
     * ‘-r[:stream_specifier] fps (input/output,per-stream)’
     * Set frame rate (Hz value, fraction or abbreviation).
     *
     * As an input option, ignore any timestamps stored in the file and instead generate timestamps assuming constant
     * frame rate fps.
     *
     * As an output option, duplicate or drop input frames to achieve constant output frame rate fps
     * (note that this actually causes the fps filter to be inserted to the end of the corresponding filtergraph).
     */
    public AVVideoOptions frameRate(final AVStreamType streamType, final Integer rate) {
        return flags(FLAG_FRAME_RATE, rate);
    }

    public AVVideoOptions frameRate(final Integer rate) {
        return frameRate(null, rate);
    }

    /**
     * ‘-movflags frag_keyframe’
     * Start a new fragment at each video keyframe.
     */
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
    public AVVideoOptions framesCount(final Long count) {
        return flags(FLAG_VIDEO_FRAMES_COUNT, count);
    }

    /**
     * ‘-aspect[:stream_specifier] aspect (output,per-stream)’
     * Set the video display aspect ratio specified by aspect.
     *
     * aspect can be a floating point number string, or a string of the form num:den, where num and den are the
     * numerator and denominator of the aspect ratio. For example "4:3", "16:9", "1.3333", and "1.7777" are valid
     * argument values.
     */
    public AVVideoOptions aspectRatio(final AVStreamType streamType, final String ratio) {
        return flags(specifyStream(FLAG_ASPECT_RATIO, streamType), ratio);
    }

    public AVVideoOptions aspectRatio(final String ratio) {
        return aspectRatio(null, ratio);
    }

    public AVVideoOptions aspectRatio(final AVStreamType streamType, final Integer width, final Integer height) {
        return aspectRatio(streamType, format("%d:%d", width, height));
    }

    public AVVideoOptions aspectRatio(final Integer width, final Integer height) {
        return aspectRatio(null, width, height);
    }

    public AVVideoOptions aspectRatio(final AVStreamType streamType, final Double ratio) {
        return aspectRatio(streamType, format("%.4f", ratio));
    }

    public AVVideoOptions aspectRatio(final Double ratio) {
        return aspectRatio(null, ratio);
    }

    /**
     * ‘-vn (output)’
     * Disable video recording.
     */
    public AVVideoOptions disableRecording() {
        return flags(FLAG_DISABLE_VIDEO_RECORDING);
    }

    /**
     * ‘-pass[:stream_specifier] n (output,per-stream)’
     * Select the pass number (1 or 2). It is used to do two-pass video encoding. The statistics of the video are
     * recorded in the first pass into a log file (see also the option -passlogfile), and in the second pass that log
     * file is used to generate the video at the exact requested bitrate. On pass 1, you may just deactivate audio
     * and set output to null, examples for Windows and Unix:
     *
     * avconv -i foo.mov -c:v libxvid -pass 1 -an -f rawvideo -y NUL
     * avconv -i foo.mov -c:v libxvid -pass 1 -an -f rawvideo -y /dev/null
     */
    public AVVideoOptions passCount(final AVStreamType streamType, final Integer pass) {
        return flags(specifyStream(FLAG_PASS_COUNT, streamType), pass);
    }

    public AVVideoOptions passCount(final Integer pass) {
        return passCount(null, pass);
    }

    public AVVideoOptions onePassEncoding(final AVStreamType streamType) {
        return passCount(streamType, 1);
    }

    public AVVideoOptions onePassEncoding() {
        return onePassEncoding(null);
    }

    public AVVideoOptions twoPassEncoding(final AVStreamType streamType) {
        return passCount(streamType, 2);
    }

    public AVVideoOptions twoPassEncoding() {
        return twoPassEncoding(null);
    }

    /**
     * ‘-passlogfile[:stream_specifier] prefix (output,per-stream)’
     * Set two-pass log file name prefix to prefix, the default file name prefix is “av2pass”.
     * The complete file name will be ‘PREFIX-N.log’, where N is a number specific to the output stream.
     */
    public AVVideoOptions passLogFilePrefix(final AVStreamType streamType, final String prefix) {
        return flags(specifyStream(FLAG_PASS_LOG_FILE_PREFIX, streamType), prefix);
    }

    public AVVideoOptions passLogFilePrefix(final String prefix) {
        return passLogFilePrefix(null, prefix);
    }

}
