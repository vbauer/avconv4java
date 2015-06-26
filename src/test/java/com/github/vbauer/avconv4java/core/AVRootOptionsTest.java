package com.github.vbauer.avconv4java.core;

import com.beust.jcommander.internal.Lists;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

/**
 * @author Vladislav Bauer
 */

public class AVRootOptionsTest {

    private static final String INPUT_FILE = "inputFile";
    private static final String OUTPUT_FILE = "outputFile";


    @Test
    public void testSmokeAVRootOptions() {
        final AVRootOptions rootOptions = AVRootOptions.create(INPUT_FILE, OUTPUT_FILE)
            .builders(Lists.<AVOptions>newArrayList())
            .builders()
            .flags(Lists.newArrayList())
            .flags();

        Assert.assertEquals(rootOptions.getOutputFile(), OUTPUT_FILE);

        final List<String> options = rootOptions.build();
        Assert.assertFalse(options.isEmpty());
    }

}
