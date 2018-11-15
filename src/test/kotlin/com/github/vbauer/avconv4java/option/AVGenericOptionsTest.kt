package com.github.vbauer.avconv4java.option

import com.github.vbauer.avconv4java.type.AVLogLevelType
import org.hamcrest.MatcherAssert.assertThat
import org.hamcrest.Matchers.emptyIterable
import org.hamcrest.Matchers.not
import org.testng.annotations.Test
import org.testng.collections.Lists

/**
 * @author Vladislav Bauer
 */

class AVGenericOptionsTest {

    @Test
    fun testSmokeAVGenericOptions() {
        val options = AVGenericOptions.create()
                .cpuFlags("mask")
                .logLevel(1)
                .logLevel(AVLogLevelType.DEBUG)
                .logLevel(AVLogLevelType.DEBUG.getName())
                .showLicense()
                .builders(Lists.newArrayList())
                .builders()
                .flags(Lists.newArrayList())
                .flags()
                .build()

        assertThat(options, not(emptyIterable()))
    }

}
