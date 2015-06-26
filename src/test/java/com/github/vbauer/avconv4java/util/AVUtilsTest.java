package com.github.vbauer.avconv4java.util;

import com.github.vbauer.avconv4java.common.TestUtils;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.InputStream;
import java.io.StringReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;

/**
 * @author Vladislav Bauer
 */

public class AVUtilsTest {

    private static final String WORLD = "World!";
    private static final String HELLO = "Hello,";
    private static final String SPACE = " ";
    private static final String HELLO_WORLD = HELLO + SPACE + WORLD;

    private static final String TODO_MARKER = "[TO-DO]";
    private static final String TODO_FILE = "TODO.txt";


    @Test(expectedExceptions = UnsupportedOperationException.class)
    public void testConstructorContract() throws Throwable {
        Class<AVUtils> utilsClass = AVUtils.class;
        TestUtils.checkUtilClassConstructor(utilsClass);
    }

    @Test
    public void testIsEmptyCollection() {
        Assert.assertTrue(AVUtils.isEmpty((List) null));
        Assert.assertFalse(AVUtils.isEmpty(Collections.singleton(HELLO)));
    }

    @Test
    public void testIsEmptyMap() {
        Assert.assertTrue(AVUtils.isEmpty((Map) null));
        Assert.assertFalse(AVUtils.isEmpty(Collections.singletonMap(HELLO, WORLD)));
    }

    @Test
    public void testIsEmptyArray() {
        Assert.assertTrue(AVUtils.isEmpty((Object[]) null));
        Assert.assertFalse(AVUtils.isEmpty(HELLO, WORLD));
    }

    @Test
    public void testTrimToNull() {
        Assert.assertEquals(AVUtils.trimToNull(null), null);
        Assert.assertEquals(AVUtils.trimToNull(AVUtils.EMPTY), null);
        Assert.assertEquals(AVUtils.trimToNull(AVUtils.SPACE), null);
    }

    @Test
    public void testTrimToEmpty() {
        Assert.assertEquals(AVUtils.trimToEmpty(null), AVUtils.EMPTY);
        Assert.assertEquals(AVUtils.trimToEmpty(AVUtils.EMPTY), AVUtils.EMPTY);
        Assert.assertEquals(AVUtils.trimToEmpty(AVUtils.SPACE), AVUtils.EMPTY);
    }

    @Test
    public void testIsBlank() {
        Assert.assertTrue(AVUtils.isBlank(null));
        Assert.assertTrue(AVUtils.isBlank(AVUtils.EMPTY));
        Assert.assertTrue(AVUtils.isBlank(AVUtils.SPACE));
        Assert.assertFalse(AVUtils.isBlank(" a "));
        Assert.assertFalse(AVUtils.isBlank("a"));
    }

    @Test
    @SuppressWarnings({"unchecked", "NullArgumentToVariableArgMethod"})
    public void testHasNull() {
        Assert.assertTrue(AVUtils.hasNull(1, null));
        Assert.assertTrue(AVUtils.hasNull((Object) null));
        Assert.assertTrue(AVUtils.hasNull(null, null));
        Assert.assertTrue(AVUtils.hasNull(HELLO, null));
        Assert.assertFalse(AVUtils.hasNull(HELLO, WORLD));
    }

    @Test
    public void testJoinCollection() {
        final Iterable<String> data = Arrays.asList(HELLO, WORLD);

        Assert.assertEquals(AVUtils.SPACE, SPACE);

        Assert.assertEquals(AVUtils.join(data), AVUtils.join(data, AVUtils.SPACE));
        Assert.assertEquals(AVUtils.join(data), HELLO_WORLD);
        Assert.assertEquals(AVUtils.join(data), HELLO_WORLD);

        Assert.assertEquals(AVUtils.join(Arrays.<String>asList(null, null)), null);
        Assert.assertEquals(AVUtils.join((Iterable<String>) null), null);
    }

    @Test
    public void testJoinArray() {
        Assert.assertEquals(AVUtils.join((String) null), null);
        Assert.assertEquals(AVUtils.join((String[]) null), null);
        Assert.assertEquals(AVUtils.join(HELLO, WORLD), HELLO_WORLD);
    }

    @Test
    public void testOs() {
        Assert.assertTrue(
            AVUtils.isUnix()
            || AVUtils.isWindows()
            || AVUtils.isMac()
            || AVUtils.isSolaris()
        );
    }

    @Test
    public void testGetSystemProperty() {
        Assert.assertNotNull(AVUtils.getSystemProperty(AVUtils.SYSTEM_PROPERTY_OS_NAME));
        Assert.assertNotNull(AVUtils.getSystemProperty(AVUtils.SYSTEM_PROPERTY_LINE_SEPARATOR));
    }

    @Test
    public void testDefault() {
        Assert.assertNull(AVUtils.defaultValue(null, null));
        Assert.assertEquals(AVUtils.defaultValue(null, 1), Integer.valueOf(1));
        Assert.assertEquals(AVUtils.defaultValue(2, null), Integer.valueOf(2));
        Assert.assertEquals(AVUtils.defaultValue(3, 4), Integer.valueOf(3));
    }

    @Test
    public void testReadFully() throws Exception {
        final InputStream inputStream = ClassLoader.getSystemResourceAsStream(TODO_FILE);
        Assert.assertNotNull(inputStream);

        final String data = AVUtils.trimToEmpty(AVUtils.readFully(inputStream));
        Assert.assertTrue(data.startsWith(TODO_MARKER));
        Assert.assertTrue(data.endsWith(TODO_MARKER));

        Assert.assertNull(AVUtils.readFully(null));
    }

    @Test
    public void testCloseQuietly() {
        Assert.assertFalse(AVUtils.closeQuietly(null));
        Assert.assertTrue(AVUtils.closeQuietly(new StringReader("")));
    }

}
