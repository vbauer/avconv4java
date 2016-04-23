package com.github.vbauer.avconv4java.option;

import java.util.List;

import com.github.vbauer.avconv4java.core.AVOptions;
import org.testng.annotations.Test;
import org.testng.collections.Lists;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.emptyIterable;
import static org.hamcrest.Matchers.not;

/**
 * @author Vladislav Bauer
 */

public class AVSubtitleOptionsTest {

    @Test
    public void testSmokeAVSubtitleOptions() {
        final List<String> options = AVSubtitleOptions.create()
            .disableRecording()
            .subtitleCodec("codecName")
            .builders(Lists.<AVOptions>newArrayList())
            .builders()
            .flags(Lists.newArrayList())
            .flags()
            .build();

        assertThat(options, not(emptyIterable()));
    }

}
