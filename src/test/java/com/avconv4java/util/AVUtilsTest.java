package com.avconv4java.util;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.Collection;

/**
 * @author Vladislav Bauer
 */

@Test
public class AVUtilsTest {

    private static final String WORLD = "World!";
    private static final String HELLO = "Hello,";
    private static final String SPACE = " ";
    private static final String HELLO_WORLD = HELLO + SPACE + WORLD;


    public void testJoin() {
        final Collection<String> data = Arrays.asList(HELLO, WORLD);

        Assert.assertEquals(AVUtils.SPACE, SPACE);

        Assert.assertEquals(AVUtils.join(data), AVUtils.join(data, AVUtils.SPACE));
        Assert.assertEquals(AVUtils.join(data), HELLO_WORLD);
        Assert.assertEquals(AVUtils.join(data), HELLO_WORLD);

        Assert.assertEquals(AVUtils.join(Arrays.<String>asList(null, null)), "");
        Assert.assertEquals(AVUtils.join((String) null), "");
        Assert.assertEquals(AVUtils.join((Iterable<String>) null), "");
    }

}
