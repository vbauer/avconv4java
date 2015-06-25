package com.github.vbauer.avconv4java.option;

import com.beust.jcommander.internal.Lists;
import com.github.vbauer.avconv4java.core.AVOptions;
import com.github.vbauer.avconv4java.model.AVMovFlagsType;
import com.github.vbauer.avconv4java.model.AVStreamType;
import com.github.vbauer.avconv4java.model.AVVideoCodecType;
import com.github.vbauer.avconv4java.model.AVVideoSizeType;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

/**
 * @author Vladislav Bauer
 */

public class AVVideoOptionsTest {

    @Test
    public void testSmokeAVVideoOptions() {
        final List<String> options = AVVideoOptions.create()
            .aspectRatio(AVStreamType.VIDEO, "ration")
            .aspectRatio(AVStreamType.VIDEO, 1, 1)
            .aspectRatio(AVStreamType.VIDEO, 1.0D)
            .aspectRatio("ratio")
            .aspectRatio(1, 1)
            .aspectRatio(1.0)
            .disableRecording()
            .filter("filter")
            .frameRate(AVStreamType.AUDIO, 1)
            .frameRate(1)
            .movFlags(AVMovFlagsType.EMPTY_MOOV)
            .movFlags(AVMovFlagsType.EMPTY_MOOV.getName())
            .framesCount(1L)
            .onePassEncoding()
            .onePassEncoding(AVStreamType.AUDIO)
            .passCount(AVStreamType.AUDIO, 1)
            .passCount(1)
            .passLogFilePrefix(AVStreamType.AUDIO, "prefix")
            .passLogFilePrefix("prefix")
            .proportionalResizeUsingHeight(1)
            .proportionalResizeUsingWidth(1)
            .resize(AVStreamType.VIDEO, 1, 1)
            .resize(AVStreamType.VIDEO, AVVideoSizeType.CGA)
            .resize(AVStreamType.VIDEO, AVVideoSizeType.CGA.getName())
            .twoPassEncoding()
            .twoPassEncoding(AVStreamType.AUDIO)
            .videoCodec(AVVideoCodecType.H264)
            .videoCodec(AVVideoCodecType.H264.getName())
            .builders(Lists.<AVOptions>newArrayList())
            .builders()
            .flags(Lists.newArrayList())
            .flags()
            .build();

        Assert.assertFalse(options.isEmpty());
    }

}
