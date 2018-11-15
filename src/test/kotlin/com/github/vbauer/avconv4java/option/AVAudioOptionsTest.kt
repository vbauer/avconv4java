package com.github.vbauer.avconv4java.option

import com.github.vbauer.avconv4java.type.AVAudioCodecType
import com.github.vbauer.avconv4java.type.AVStreamType
import org.hamcrest.MatcherAssert.assertThat
import org.hamcrest.Matchers.emptyIterable
import org.hamcrest.Matchers.not
import org.testng.annotations.Test
import org.testng.collections.Lists

/**
 * @author Vladislav Bauer
 */

class AVAudioOptionsTest {

    @Test
    fun testSmokeAVAudioOptions() {
        val options = AVAudioOptions.create()
                .audioBitRate(1)
                .audioChannelsCount(AVStreamType.AUDIO, 1)
                .audioChannelsCount(1)
                .audioCodec(AVAudioCodecType.AAC)
                .audioCodec(AVAudioCodecType.AAC.getName())
                .audioQuality(1.0)
                .disableRecording()
                .filter("filter")
                .flags("flag")
                .framesCount(1L)
                .sampleFormat(AVStreamType.AUDIO, "format")
                .sampleFormat("format")
                .sampleRate(AVStreamType.AUDIO, 1)
                .sampleRate(1)
                .builders(Lists.newArrayList())
                .builders()
                .flags(Lists.newArrayList())
                .flags()
                .build()

        assertThat(options, not(emptyIterable()))
    }


}
