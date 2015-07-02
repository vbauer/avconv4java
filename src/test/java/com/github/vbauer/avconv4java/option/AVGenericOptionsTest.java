package com.github.vbauer.avconv4java.option;

import com.beust.jcommander.internal.Lists;
import com.github.vbauer.avconv4java.core.AVOptions;
import com.github.vbauer.avconv4java.type.AVLogLevelType;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

/**
 * @author Vladislav Bauer
 */

public class AVGenericOptionsTest {

    @Test
    public void testSmokeAVGenericOptions() {
        final List<String> options = AVGenericOptions.create()
            .cpuFlags("mask")
            .logLevel(1)
            .logLevel(AVLogLevelType.DEBUG)
            .logLevel(AVLogLevelType.DEBUG.getName())
            .showLicense()
            .builders(Lists.<AVOptions>newArrayList())
            .builders()
            .flags(Lists.newArrayList())
            .flags()
            .build();

        Assert.assertFalse(options.isEmpty());
    }

}
