package com.github.vbauer.avconv4java.util

import com.github.vbauer.avconv4java.common.TestUtils
import com.github.vbauer.avconv4java.util.process.ProcessExecutor
import com.github.vbauer.avconv4java.util.process.ProcessInfo
import org.hamcrest.MatcherAssert.assertThat
import org.hamcrest.Matchers.*
import org.testng.SkipException
import org.testng.annotations.Test
import org.testng.collections.Lists
import java.util.concurrent.ExecutorService

/**
 * @author Vladislav Bauer
 */

class ProcessExecutorTest {

    private val dirListCmd: List<String>
        get() {
            if (couldHaveBash()) {
                return Lists.newArrayList("ls")
            } else if (AVUtils.isWindows()) {
                return Lists.newArrayList("CMD", "/C", "DIR")
            }
            throw SkipException(MESSAGE_OS_TYPE)
        }

    private val sleepCmd: List<String>
        get() {
            if (couldHaveBash()) {
                return Lists.newArrayList("sleep", "1")
            }
            throw SkipException(MESSAGE_OS_TYPE)
        }


    @Test
    fun testConstructorContract() {
        TestUtils.checkUtilClassConstructor(ProcessExecutor::class.java)
    }

    @Test
    fun testNixCommandWithEnoughTimeout() {
        val command = dirListCmd
        assertThat(runCommand(command, 30000L, false).isSuccess, equalTo(true))
        assertThat(runCommand(command, 30000L, true).isSuccess, equalTo(true))
    }

    @Test
    fun testNixCommandWithNotEnoughTimeout() {
        val command = sleepCmd
        assertThat(runCommand(command, 1L, false).isError, equalTo(true))
        assertThat(runCommand(command, 1L, true).isError, equalTo(true))
    }

    @Test
    fun testNixCommandWithoutTimeout() {
        val command = dirListCmd
        assertThat(runCommand(command, null, false).isSuccess, equalTo(true))
        assertThat(runCommand(command, null, true).isSuccess, equalTo(true))
    }

    @Test
    fun testErrorProcessInfo() {
        val info = ProcessInfo.error(MESSAGE_OS_TYPE)
        assertThat(info.isError, equalTo(true))
        assertThat(info.isSuccess, equalTo(false))
        assertThat(info.output, nullValue())
        assertThat(info.errorOutput, equalTo(MESSAGE_OS_TYPE))
    }

    @Test
    fun testCorrectProcessInfo() {
        val info = ProcessInfo.create(ProcessInfo.EXIT_CODE_SUCCESS, MESSAGE_OS_TYPE, null)
        assertThat(info.isError, equalTo(false))
        assertThat(info.isSuccess, equalTo(true))
        assertThat(info.errorOutput, nullValue())
        assertThat(info.output, equalTo(MESSAGE_OS_TYPE))
    }

    @Test
    fun testShutdownExecutor() {
        val method = ProcessExecutor::class.java.getDeclaredMethod("shutdownExecutor", ExecutorService::class.java)
        method.isAccessible = true

        val result = method.invoke(null, null)
        assertThat(result, nullValue())
    }


    /*
     * Internal API.
     */

    private fun runCommand(command: List<String>, timeout: Long?, debug: Boolean): ProcessInfo {
        val processInfo = ProcessExecutor.execute(command, timeout, debug)
        val statusCode = processInfo.statusCode
        val errorOutput = AVUtils.trimToNull(processInfo.errorOutput)
        if (errorOutput != null) {
            assertThat(statusCode, not(equalTo(ProcessInfo.EXIT_CODE_SUCCESS)))
        }
        return processInfo
    }

    private fun couldHaveBash(): Boolean {
        val mac = AVUtils.isMac()
        val solaris = AVUtils.isSolaris()
        val unix = AVUtils.isUnix()

        return mac || solaris || unix
    }

    companion object {
        private const val MESSAGE_OS_TYPE = "Test is only for Solaris, Unix, Windows and Mac"
    }

}
