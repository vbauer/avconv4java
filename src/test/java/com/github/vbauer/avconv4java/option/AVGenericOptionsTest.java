package com.github.vbauer.avconv4java.option;

import java.util.List;

import com.github.vbauer.avconv4java.core.AVOptions;
import com.github.vbauer.avconv4java.type.AVLogLevelType;
import org.testng.annotations.Test;
import org.testng.collections.Lists;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.emptyIterable;
import static org.hamcrest.Matchers.not;

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

        assertThat(options, not(emptyIterable()));
    }

}
