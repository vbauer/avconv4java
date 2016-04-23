package com.github.vbauer.avconv4java.util;

import java.io.InputStream;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import com.github.vbauer.avconv4java.common.TestUtils;
import org.testng.annotations.Test;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.notNullValue;
import static org.hamcrest.Matchers.nullValue;

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


    @Test
    public void testConstructorContract() throws Throwable {
        TestUtils.checkUtilClassConstructor(AVUtils.class);
    }

    @Test
    public void testIsEmptyCollection() {
        assertThat(AVUtils.isEmpty((List) null), equalTo(true));
        assertThat(AVUtils.isEmpty(Collections.singleton(HELLO)), equalTo(false));
    }

    @Test
    public void testIsEmptyMap() {
        assertThat(AVUtils.isEmpty((Map) null), equalTo(true));
        assertThat(AVUtils.isEmpty(Collections.singletonMap(HELLO, WORLD)), equalTo(false));
    }

    @Test
    public void testIsEmptyArray() {
        assertThat(AVUtils.isEmpty((Object[]) null), equalTo(true));
        assertThat(AVUtils.isEmpty(HELLO, WORLD), equalTo(false));
    }

    @Test
    public void testTrimToNull() {
        assertThat(AVUtils.trimToNull(null), nullValue());
        assertThat(AVUtils.trimToNull(AVUtils.EMPTY), nullValue());
        assertThat(AVUtils.trimToNull(AVUtils.SPACE), nullValue());
    }

    @Test
    public void testTrimToEmpty() {
        assertThat(AVUtils.trimToEmpty(null), equalTo(AVUtils.EMPTY));
        assertThat(AVUtils.trimToEmpty(AVUtils.EMPTY), equalTo(AVUtils.EMPTY));
        assertThat(AVUtils.trimToEmpty(AVUtils.SPACE), equalTo(AVUtils.EMPTY));
    }

    @Test
    public void testIsBlank() {
        assertThat(AVUtils.isBlank(null), equalTo(true));
        assertThat(AVUtils.isBlank(AVUtils.EMPTY), equalTo(true));
        assertThat(AVUtils.isBlank(AVUtils.SPACE), equalTo(true));
        assertThat(AVUtils.isBlank(" a "), equalTo(false));
        assertThat(AVUtils.isBlank("a"), equalTo(false));
    }

    @Test
    @SuppressWarnings("all")
    public void testHasNull() {
        assertThat(AVUtils.hasNull(1, null), equalTo(true));
        assertThat(AVUtils.hasNull((Object) null), equalTo(true));
        assertThat(AVUtils.hasNull(null, null), equalTo(true));
        assertThat(AVUtils.hasNull(HELLO, null), equalTo(true));
        assertThat(AVUtils.hasNull(HELLO, WORLD), equalTo(false));
    }

    @Test
    public void testJoinCollection() {
        final Iterable<String> data = Arrays.asList(HELLO, WORLD);

        assertThat(AVUtils.SPACE, equalTo(SPACE));

        assertThat(AVUtils.join(data), equalTo(AVUtils.join(data, AVUtils.SPACE)));
        assertThat(AVUtils.join(data), equalTo(HELLO_WORLD));
        assertThat(AVUtils.join(data), equalTo(HELLO_WORLD));

        assertThat(AVUtils.join(Arrays.<String>asList(null, null)), nullValue());
        assertThat(AVUtils.join((Iterable<String>) null), nullValue());
    }

    @Test
    public void testJoinArray() {
        assertThat(AVUtils.join((String) null), nullValue());
        assertThat(AVUtils.join((String[]) null), nullValue());
        assertThat(AVUtils.join(HELLO, WORLD), equalTo(HELLO_WORLD));
    }

    @Test
    public void testOs() {
        assertThat(
            AVUtils.isUnix()
                || AVUtils.isWindows()
                || AVUtils.isMac()
                || AVUtils.isSolaris(),
            equalTo(true)
        );
    }

    @Test
    public void testGetSystemProperty() {
        assertThat(AVUtils.getSystemProperty(AVUtils.SYSTEM_PROPERTY_OS_NAME), notNullValue());
        assertThat(AVUtils.getSystemProperty(AVUtils.SYSTEM_PROPERTY_LINE_SEPARATOR), notNullValue());
    }

    @Test
    public void testReadFully() throws Exception {
        final InputStream inputStream = ClassLoader.getSystemResourceAsStream(TODO_FILE);
        assertThat(inputStream, notNullValue());

        final String data = AVUtils.trimToEmpty(AVUtils.readFully(inputStream));
        assertThat(data.startsWith(TODO_MARKER), equalTo(true));
        assertThat(data.endsWith(TODO_MARKER), equalTo(true));

        assertThat(AVUtils.readFully(null), nullValue());
    }

}
