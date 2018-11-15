package com.github.vbauer.avconv4java.option

import com.github.vbauer.avconv4java.type.AVErrorDetectionType
import com.github.vbauer.avconv4java.type.AVFormatDebugInfoType
import com.github.vbauer.avconv4java.type.AVFormatFlagType
import org.hamcrest.MatcherAssert.assertThat
import org.hamcrest.Matchers.emptyIterable
import org.hamcrest.Matchers.not
import org.testng.annotations.Test
import org.testng.collections.Lists

/**
 * @author Vladislav Bauer
 */

class AVFormatOptionsTest {

    @Test
    fun testSmokeAVFormatOptions() {
        val options = AVFormatOptions.create()
                .analyzeDuration(1L)
                .debugInfo(AVFormatDebugInfoType.TS)
                .debugInfo(AVFormatDebugInfoType.TS.getName())
                .decryptionKey("key")
                .errorDetection(AVErrorDetectionType.BIT_STREAM)
                .errorDetection(AVErrorDetectionType.BIT_STREAM.getName())
                .formatFlags(AVFormatFlagType.DISCARD_CORRUPTED)
                .formatFlags(AVFormatFlagType.DISCARD_CORRUPTED.getName())
                .fpsProbeSize(1L)
                .interleavingBufferSize(1L)
                .maxDelay(1L)
                .packetSize(1L)
                .probeSize(1L)
                .realTimeBufferSize(1L)
                .timestampIndexSize(1L)
                .builders(Lists.newArrayList())
                .builders()
                .flags(Lists.newArrayList())
                .flags()
                .build()

        assertThat(options, not(emptyIterable()))
    }

}
