package com.github.vbauer.avconv4java.core;

import org.testng.annotations.Test;
import org.testng.collections.Lists;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

/**
 * @author Vladislav Bauer
 */

public class AVRootOptionsTest {

    private static final String INPUT_FILE = "inputFile";
    private static final String OUTPUT_FILE = "outputFile";


    @Test
    public void testSmokeAVRootOptions() {
        final AVRootOptions rootOptions = AVRootOptions.create(INPUT_FILE, OUTPUT_FILE)
            .builders(Lists.newArrayList())
            .builders()
            .flags(Lists.newArrayList())
            .flags();

        assertThat(rootOptions.getOutputFile(), equalTo(OUTPUT_FILE));

        final List<String> options = rootOptions.build();
        assertThat(options, not(emptyIterable()));
    }

}
