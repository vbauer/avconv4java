package com.github.vbauer.avconv4java.core

import org.hamcrest.MatcherAssert.assertThat
import org.hamcrest.Matchers.*
import org.testng.annotations.Test
import org.testng.collections.Lists

/**
 * @author Vladislav Bauer
 */

class AVRootOptionsTest {

    @Test
    fun testSmokeAVRootOptions() {
        val rootOptions = AVRootOptions.create(INPUT_FILE, OUTPUT_FILE)
                .builders(Lists.newArrayList())
                .builders()
                .flags(Lists.newArrayList())
                .flags()

        assertThat(rootOptions.outputFile, equalTo(OUTPUT_FILE))

        val options = rootOptions.build()
        assertThat(options, not(emptyIterable()))
    }

    companion object {
        private const val INPUT_FILE = "inputFile"
        private const val OUTPUT_FILE = "outputFile"
    }

}
