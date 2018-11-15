package com.github.vbauer.avconv4java.option.advanced

import com.github.vbauer.avconv4java.type.AVVideoSyncType
import org.hamcrest.MatcherAssert.assertThat
import org.hamcrest.Matchers.emptyIterable
import org.hamcrest.Matchers.not
import org.testng.annotations.Test
import org.testng.collections.Lists

/**
 * @author Vladislav Bauer
 */

class AVAdvancedOptionsTest {

    @Test
    fun testSmokeAVAdvancedOptions() {
        val options = AVAdvancedOptions.create()
                .accurateSeek(true)
                .benchmark()
                .copyTimeBase()
                .copyTimestamps()
                .demuxPreLoadDelay(1L)
                .discontinuityDeltaThreshold()
                .dump()
                .filterComplexScript("fileName")
                .hex()
                .maxDemuxDelay(1L)
                .shortest()
                .timeLimit(1L)
                .videoSyncMethod(AVVideoSyncType.AUTO)
                .videoSyncMethod(AVVideoSyncType.AUTO.getName())
                .builders(Lists.newArrayList())
                .builders()
                .flags(Lists.newArrayList())
                .flags()
                .build()

        assertThat(options, not(emptyIterable()))
    }

}
