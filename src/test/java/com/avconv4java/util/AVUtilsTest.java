package com.avconv4java.util;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.Map;

/**
 * @author Vladislav Bauer
 */

@Test
public class AVUtilsTest {

    private static final String WORLD = "World!";
    private static final String HELLO = "Hello,";
    private static final String SPACE = " ";
    private static final String HELLO_WORLD = HELLO + SPACE + WORLD;


    public void testIsEmptyMap() {
        Assert.assertTrue(AVUtils.isEmpty((Map) null));
        Assert.assertFalse(AVUtils.isEmpty(Collections.singletonMap(HELLO, WORLD)));
    }

    public void testIsEmptyArray() {
        Assert.assertTrue(AVUtils.isEmpty((Object[]) null));
        Assert.assertFalse(AVUtils.isEmpty(new String[]{HELLO, WORLD}));
    }


    public void testTrimToNull() {
        Assert.assertEquals(AVUtils.trimToNull(null), null);
        Assert.assertEquals(AVUtils.trimToNull(AVUtils.EMPTY), null);
        Assert.assertEquals(AVUtils.trimToNull(AVUtils.SPACE), null);
    }

    public void testTrimToEmpty() {
        Assert.assertEquals(AVUtils.trimToEmpty(null), AVUtils.EMPTY);
        Assert.assertEquals(AVUtils.trimToEmpty(AVUtils.EMPTY), AVUtils.EMPTY);
        Assert.assertEquals(AVUtils.trimToEmpty(AVUtils.SPACE), AVUtils.EMPTY);
    }


    @SuppressWarnings({"unchecked", "NullArgumentToVariableArgMethod"})
    public void testHasNull() {
        Assert.assertTrue(AVUtils.hasNull(null));
        Assert.assertTrue(AVUtils.hasNull(null, null));
        Assert.assertTrue(AVUtils.hasNull(HELLO, null));
        Assert.assertFalse(AVUtils.hasNull(HELLO, WORLD));
    }

    public void testJoinCollection() {
        final Iterable<String> data = Arrays.asList(HELLO, WORLD);

        Assert.assertEquals(AVUtils.SPACE, SPACE);

        Assert.assertEquals(AVUtils.join(data), AVUtils.join(data, AVUtils.SPACE));
        Assert.assertEquals(AVUtils.join(data), HELLO_WORLD);
        Assert.assertEquals(AVUtils.join(data), HELLO_WORLD);

        Assert.assertEquals(AVUtils.join(Arrays.<String>asList(null, null)), null);
        Assert.assertEquals(AVUtils.join((Iterable<String>) null), null);
    }

    public void testJoinArray() {
        Assert.assertEquals(AVUtils.join((String) null), null);
        Assert.assertEquals(AVUtils.join((String[]) null), null);
        Assert.assertEquals(AVUtils.join(HELLO, WORLD), HELLO_WORLD);
    }

}
