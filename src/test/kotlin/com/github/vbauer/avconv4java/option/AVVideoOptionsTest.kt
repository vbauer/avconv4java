package com.github.vbauer.avconv4java.option

import com.github.vbauer.avconv4java.type.AVMovFlagsType
import com.github.vbauer.avconv4java.type.AVStreamType
import com.github.vbauer.avconv4java.type.AVVideoCodecType
import com.github.vbauer.avconv4java.type.AVVideoSizeType
import org.hamcrest.MatcherAssert.assertThat
import org.hamcrest.Matchers.emptyIterable
import org.hamcrest.Matchers.not
import org.testng.annotations.Test
import org.testng.collections.Lists

/**
 * @author Vladislav Bauer
 */

class AVVideoOptionsTest {

    @Test
    fun testSmokeAVVideoOptions() {
        val options = AVVideoOptions.create()
                .aspectRatio(AVStreamType.VIDEO, "ration")
                .aspectRatio(AVStreamType.VIDEO, 1, 1)
                .aspectRatio(AVStreamType.VIDEO, 1.0)
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
                .builders(Lists.newArrayList())
                .builders()
                .flags(Lists.newArrayList())
                .flags()
                .build()

        assertThat(options, not(emptyIterable()))
    }

}
