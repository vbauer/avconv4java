package com.github.vbauer.avconv4java.util;

import com.github.vbauer.avconv4java.common.TestUtils;
import com.github.vbauer.avconv4java.util.process.ProcessExecutor;
import com.github.vbauer.avconv4java.util.process.ProcessInfo;
import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.Test;
import org.testng.collections.Lists;

import java.util.List;

/**
 * @author Vladislav Bauer
 */

public class ProcessExecutorTest {

    private static final String MESSAGE_OS_TYPE = "Test is only for Solaris, Unix, Windows and Mac";


    @Test(expectedExceptions = UnsupportedOperationException.class)
    public void testConstructorContract() throws Throwable {
        TestUtils.checkUtilClassConstructor(ProcessExecutor.class);
    }

    @Test
    public void testNixCommandWithEnoughTimeout() throws Throwable {
        final List<String> command = getDirListCmd();
        Assert.assertTrue(runCommand(command, 30000L, false).isSuccess());
        Assert.assertTrue(runCommand(command, 30000L, true).isSuccess());
    }

    @Test
    public void testNixCommandWithNotEnoughTimeout() throws Throwable {
        final List<String> command = getSleepCmd();
        Assert.assertTrue(runCommand(command, 1L, false).isError());
        Assert.assertTrue(runCommand(command, 1L, true).isError());
    }

    @Test
    public void testNixCommandWithoutTimeout() throws Throwable {
        final List<String> command = getDirListCmd();
        Assert.assertTrue(runCommand(command, null, false).isSuccess());
        Assert.assertTrue(runCommand(command, null, true).isSuccess());
    }

    @Test
    public void testErrorProcessInfo() {
        final ProcessInfo info = ProcessInfo.error(MESSAGE_OS_TYPE);
        Assert.assertTrue(info.isError());
        Assert.assertFalse(info.isSuccess());
        Assert.assertNull(info.getOutput());
        Assert.assertEquals(info.getErrorOutput(), MESSAGE_OS_TYPE);
    }

    @Test
    public void testCorrectProcessInfo() {
        final ProcessInfo info = ProcessInfo.create(ProcessInfo.EXIT_CODE_SUCCESS, MESSAGE_OS_TYPE, null);
        Assert.assertFalse(info.isError());
        Assert.assertTrue(info.isSuccess());
        Assert.assertNull(info.getErrorOutput());
        Assert.assertEquals(info.getOutput(), MESSAGE_OS_TYPE);
    }


    /*
     * Internal API.
     */

    private ProcessInfo runCommand(final List<String> command, final Long timeout, boolean debug) throws Exception {
        final ProcessInfo processInfo = ProcessExecutor.execute(command, timeout, debug);
        final int statusCode = processInfo.getStatusCode();
        final String errorOutput = AVUtils.trimToNull(processInfo.getErrorOutput());
        if (errorOutput != null) {
            Assert.assertTrue(statusCode != ProcessInfo.EXIT_CODE_SUCCESS);
        }
        return processInfo;
    }

    private List<String> getDirListCmd() {
        if (AVUtils.isMac() || AVUtils.isSolaris() || AVUtils.isUnix()) {
            return Lists.newArrayList("ls");
        } else if (AVUtils.isWindows()) {
            return Lists.newArrayList("CMD", "/C", "DIR");
        }
        throw new SkipException(MESSAGE_OS_TYPE);
    }

    private List<String> getSleepCmd() {
        if (AVUtils.isMac() || AVUtils.isSolaris() || AVUtils.isUnix()) {
            return Lists.newArrayList("sleep", "1");
        }
        // XXX: Test is not run on Windows, because OS does not have command "sleep".
        throw new SkipException(MESSAGE_OS_TYPE);
    }

}
