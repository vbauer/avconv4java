package com.github.vbauer.avconv4java.option.advanced;

import com.beust.jcommander.internal.Lists;
import com.github.vbauer.avconv4java.core.AVOptions;
import com.github.vbauer.avconv4java.model.AVVideoSyncType;
import com.github.vbauer.avconv4java.option.advacned.AVAdvancedOptions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

/**
 * @author Vladislav Bauer
 */

public class AVAdvancedOptionsTest {

    @Test
    public void testSmokeAVAdvancedOptions() {
        final List<String> options = AVAdvancedOptions.create()
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
            .builders(Lists.<AVOptions>newArrayList())
            .builders()
            .flags(Lists.newArrayList())
            .flags()
            .build();

        Assert.assertFalse(options.isEmpty());
    }

}
