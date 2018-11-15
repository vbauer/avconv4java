package com.github.vbauer.avconv4java.util

import com.github.vbauer.avconv4java.common.TestUtils
import org.hamcrest.MatcherAssert.assertThat
import org.hamcrest.Matchers.*
import org.testng.annotations.Test
import java.util.*

/**
 * @author Vladislav Bauer
 */

class AVUtilsTest {

    @Test
    fun testConstructorContract() {
        TestUtils.checkUtilClassConstructor(AVUtils::class.java)
    }

    @Test
    fun testIsEmptyCollection() {
        assertThat(AVUtils.isEmpty(null as List<*>?), equalTo(true))
        assertThat(AVUtils.isEmpty(Collections.singleton(HELLO)), equalTo(false))
    }

    @Test
    fun testIsEmptyMap() {
        assertThat(AVUtils.isEmpty(null as Map<*, *>?), equalTo(true))
        assertThat(AVUtils.isEmpty(Collections.singletonMap(HELLO, WORLD)), equalTo(false))
    }

    @Test
    fun testIsEmptyArray() {
        assertThat(AVUtils.isEmpty(), equalTo(true))
        assertThat(AVUtils.isEmpty(arrayOf(HELLO), WORLD), equalTo(false))
    }

    @Test
    fun testTrimToNull() {
        assertThat(AVUtils.trimToNull(null), nullValue())
        assertThat(AVUtils.trimToNull(AVUtils.EMPTY), nullValue())
        assertThat(AVUtils.trimToNull(AVUtils.SPACE), nullValue())
    }

    @Test
    fun testTrimToEmpty() {
        assertThat(AVUtils.trimToEmpty(null), equalTo(AVUtils.EMPTY))
        assertThat(AVUtils.trimToEmpty(AVUtils.EMPTY), equalTo(AVUtils.EMPTY))
        assertThat(AVUtils.trimToEmpty(AVUtils.SPACE), equalTo(AVUtils.EMPTY))
    }

    @Test
    fun testIsBlank() {
        assertThat(AVUtils.isBlank(null), equalTo(true))
        assertThat(AVUtils.isBlank(AVUtils.EMPTY), equalTo(true))
        assertThat(AVUtils.isBlank(AVUtils.SPACE), equalTo(true))
        assertThat(AVUtils.isBlank(" a "), equalTo(false))
        assertThat(AVUtils.isBlank("a"), equalTo(false))
    }

    @Test
    fun testHasNull() {
        assertThat(AVUtils.hasNull(1, null), equalTo(true))
        assertThat(AVUtils.hasNull(null as Any?), equalTo(true))
        assertThat(AVUtils.hasNull(null, null), equalTo(true))
        assertThat(AVUtils.hasNull(HELLO, null), equalTo(true))
        assertThat(AVUtils.hasNull(HELLO, WORLD), equalTo(false))
    }

    @Test
    fun testJoinCollection() {
        val data = Arrays.asList(HELLO, WORLD)

        assertThat(AVUtils.SPACE, equalTo(SPACE))

        assertThat(AVUtils.join(data), equalTo(AVUtils.join(data, AVUtils.SPACE)))
        assertThat(AVUtils.join(data), equalTo(HELLO_WORLD))
        assertThat(AVUtils.join(data), equalTo(HELLO_WORLD))

        assertThat(AVUtils.join(Arrays.asList<String>(null, null)), nullValue())
        assertThat(AVUtils.join(null as Iterable<String>?), nullValue())
    }

    @Test
    fun testJoinArray() {
        assertThat(AVUtils.join(null as String?), nullValue())
        assertThat(AVUtils.join(null as Collection<String>?), nullValue())
        assertThat(AVUtils.join(HELLO, WORLD), equalTo(HELLO_WORLD))
    }

    @Test
    fun testOs() {
        assertThat(
                AVUtils.isUnix()
                        || AVUtils.isWindows()
                        || AVUtils.isMac()
                        || AVUtils.isSolaris(),
                equalTo(true)
        )
    }

    @Test
    fun testGetSystemProperty() {
        assertThat(AVUtils.getSystemProperty(AVUtils.SYSTEM_PROPERTY_OS_NAME), notNullValue())
        assertThat(AVUtils.getSystemProperty(AVUtils.SYSTEM_PROPERTY_LINE_SEPARATOR), notNullValue())
    }

    @Test
    fun testReadFully() {
        val inputStream = ClassLoader.getSystemResourceAsStream(TODO_FILE)
        assertThat(inputStream, notNullValue())

        val data = AVUtils.trimToEmpty(AVUtils.readFully(inputStream))
        assertThat(data.startsWith(TODO_MARKER), equalTo(true))
        assertThat(data.endsWith(TODO_MARKER), equalTo(true))

        assertThat(AVUtils.readFully(null), nullValue())
    }

    companion object {
        private const val WORLD = "World!"
        private const val HELLO = "Hello,"
        private const val SPACE = " "
        private const val HELLO_WORLD = HELLO + SPACE + WORLD

        private const val TODO_MARKER = "[TO-DO]"
        private const val TODO_FILE = "TODO.txt"
    }

}
