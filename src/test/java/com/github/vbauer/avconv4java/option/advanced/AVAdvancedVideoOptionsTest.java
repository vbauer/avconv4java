package com.github.vbauer.avconv4java.option.advanced;

import com.beust.jcommander.internal.Lists;
import com.github.vbauer.avconv4java.core.AVOptions;
import com.github.vbauer.avconv4java.model.AVHardwareAccelerationType;
import com.github.vbauer.avconv4java.model.AVStreamType;
import com.github.vbauer.avconv4java.option.advacned.AVAdvancedVideoOptions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

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

        Assert.assertFalse(options.isEmpty());
    }

}
