package com.github.vbauer.avconv4java.option.advanced;

import java.util.List;

import com.github.vbauer.avconv4java.core.AVOptions;
import com.github.vbauer.avconv4java.type.AVHardwareAccelerationType;
import com.github.vbauer.avconv4java.type.AVStreamType;
import org.testng.annotations.Test;
import org.testng.collections.Lists;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.emptyIterable;
import static org.hamcrest.Matchers.not;

/**
 * @author Vladislav Bauer
 */

public class AVAdvancedVideoOptionsTest {

    @Test
    public void testSmokeAVAdvancedVideoOptions() {
        final List<String> options = AVAdvancedVideoOptions.create()
            .discardThreshold(1)
            .dumpVideoEncodingStatistics()
            .dumpVideoEncodingStatistics("fileName")
            .hardwareAcceleration(AVStreamType.AUDIO, AVHardwareAccelerationType.AUTO)
            .hardwareAcceleration(AVStreamType.AUDIO, AVHardwareAccelerationType.AUTO.getName())
            .pixelFormat(AVStreamType.AUDIO, "format")
            .pixelFormat("format")
            .swScalerFlags("flags")
            .builders(Lists.<AVOptions>newArrayList())
            .builders()
            .flags(Lists.newArrayList())
            .flags()
            .build();

        assertThat(options, not(emptyIterable()));
    }

}
