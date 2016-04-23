package com.github.vbauer.avconv4java.option.advanced;

import java.util.List;

import com.github.vbauer.avconv4java.core.AVOptions;
import com.github.vbauer.avconv4java.type.AVVideoSyncType;
import org.testng.annotations.Test;
import org.testng.collections.Lists;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.emptyIterable;
import static org.hamcrest.Matchers.not;

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

        assertThat(options, not(emptyIterable()));
    }

}
