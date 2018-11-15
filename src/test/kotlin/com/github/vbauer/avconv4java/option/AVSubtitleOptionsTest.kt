package com.github.vbauer.avconv4java.option

import org.hamcrest.MatcherAssert.assertThat
import org.hamcrest.Matchers.emptyIterable
import org.hamcrest.Matchers.not
import org.testng.annotations.Test
import org.testng.collections.Lists

/**
 * @author Vladislav Bauer
 */

class AVSubtitleOptionsTest {

    @Test
    fun testSmokeAVSubtitleOptions() {
        val options = AVSubtitleOptions.create()
                .disableRecording()
                .subtitleCodec("codecName")
                .builders(Lists.newArrayList())
                .builders()
                .flags(Lists.newArrayList())
                .flags()
                .build()

        assertThat(options, not(emptyIterable()))
    }

}
