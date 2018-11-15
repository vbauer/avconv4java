package com.github.vbauer.avconv4java.option.advanced

import com.github.vbauer.avconv4java.type.AVHardwareAccelerationType
import com.github.vbauer.avconv4java.type.AVStreamType
import org.hamcrest.MatcherAssert.assertThat
import org.hamcrest.Matchers.emptyIterable
import org.hamcrest.Matchers.not
import org.testng.annotations.Test
import org.testng.collections.Lists

/**
 * @author Vladislav Bauer
 */

class AVAdvancedVideoOptionsTest {

    @Test
    fun testSmokeAVAdvancedVideoOptions() {
        val options = AVAdvancedVideoOptions.create()
                .discardThreshold(1)
                .dumpVideoEncodingStatistics()
                .dumpVideoEncodingStatistics("fileName")
                .hardwareAcceleration(AVStreamType.AUDIO, AVHardwareAccelerationType.AUTO)
                .hardwareAcceleration(AVStreamType.AUDIO, AVHardwareAccelerationType.AUTO.getName())
                .pixelFormat(AVStreamType.AUDIO, "format")
                .pixelFormat("format")
                .swScalerFlags("flags")
                .builders(Lists.newArrayList())
                .builders()
                .flags(Lists.newArrayList())
                .flags()
                .build()

        assertThat(options, not(emptyIterable()))
    }

}
