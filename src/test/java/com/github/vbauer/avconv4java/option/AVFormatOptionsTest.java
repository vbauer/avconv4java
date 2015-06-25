package com.github.vbauer.avconv4java.option;

import com.beust.jcommander.internal.Lists;
import com.github.vbauer.avconv4java.core.AVOptions;
import com.github.vbauer.avconv4java.model.AVErrorDetectionType;
import com.github.vbauer.avconv4java.model.AVFormatDebugInfoType;
import com.github.vbauer.avconv4java.model.AVFormatFlagType;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

/**
 * @author Vladislav Bauer
 */

public class AVFormatOptionsTest {

    @Test
    public void testSmokeAVFormatOptions() {
        final List<String> options = AVFormatOptions.create()
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
            .builders(Lists.<AVOptions>newArrayList())
            .builders()
            .flags(Lists.newArrayList())
            .flags()
            .build();

        Assert.assertFalse(options.isEmpty());
    }

}
