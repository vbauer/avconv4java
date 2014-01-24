package com.avconv4java.util;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.Collection;

/**
 * @author Vladislav Bauer
 */

@Test
public class AVTextUtilsTest {

    private static final String WORLD = "World!";
    private static final String HELLO = "Hello,";
    private static final String SPACE = " ";
    private static final String HELLO_WORLD = HELLO + SPACE + WORLD;


    public void testJoin() {
        final Collection<String> data = Arrays.asList(HELLO, WORLD);

        Assert.assertEquals(AVTextUtils.SPACE, SPACE);

        Assert.assertEquals(AVTextUtils.join(data), AVTextUtils.join(data, AVTextUtils.SPACE));
        Assert.assertEquals(AVTextUtils.join(data), HELLO_WORLD);
        Assert.assertEquals(AVTextUtils.join(data), HELLO_WORLD);

        Assert.assertEquals(AVTextUtils.join(Arrays.<String>asList(null, null)), "");
        Assert.assertEquals(AVTextUtils.join(null), "");
    }

}
