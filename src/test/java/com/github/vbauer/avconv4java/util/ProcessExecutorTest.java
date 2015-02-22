package com.github.vbauer.avconv4java.util;

import com.github.vbauer.avconv4java.util.process.ProcessExecutor;
import com.github.vbauer.avconv4java.util.process.ProcessInfo;
import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;

/**
 * @author Vladislav Bauer
 */

@Test
public class ProcessExecutorTest {

    private static final String MESSAGE_OS_TYPE = "Test is only for Solaris, Unix, Windows and Mac";


    public void testNixCommandWithEnoughTimeout() throws Exception {
        final List<String> command = getDirListCmd();
        Assert.assertTrue(runCommand(command, 30000L, false).isSuccess());
        Assert.assertTrue(runCommand(command, 30000L, true).isSuccess());
    }

    public void testNixCommandWithNotEnoughTimeout() throws Exception {
        final List<String> command = getSleepCmd();
        Assert.assertTrue(runCommand(command, 1L, false).isError());
        Assert.assertTrue(runCommand(command, 1L, true).isError());
    }

    public void testNixCommandWithoutTimeout() throws Exception {
        final List<String> command = getDirListCmd();
        Assert.assertTrue(runCommand(command, null, false).isSuccess());
        Assert.assertTrue(runCommand(command, null, true).isSuccess());
    }

    public void testErrorProcessInfo() {
        final ProcessInfo info = ProcessInfo.error(MESSAGE_OS_TYPE);
        Assert.assertTrue(info.isError());
        Assert.assertFalse(info.isSuccess());
        Assert.assertNull(info.getOutput());
        Assert.assertEquals(info.getErrorOutput(), MESSAGE_OS_TYPE);
    }

    public void testCorrectProcessInfo() {
        final ProcessInfo info = ProcessInfo.create(ProcessInfo.EXIT_CODE_SUCCESS, MESSAGE_OS_TYPE, null);
        Assert.assertFalse(info.isError());
        Assert.assertTrue(info.isSuccess());
        Assert.assertNull(info.getErrorOutput());
        Assert.assertEquals(info.getOutput(), MESSAGE_OS_TYPE);
    }


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
            return Arrays.asList("ls");
        }
        // XXX: Test is not run on Windows.
        throw new SkipException(MESSAGE_OS_TYPE);
    }

    private List<String> getSleepCmd() {
        if (AVUtils.isMac() || AVUtils.isSolaris() || AVUtils.isUnix()) {
            return Arrays.asList("sleep", "1");
        }
        // XXX: Test is not run on Windows, because OS does not have command "sleep".
        throw new SkipException(MESSAGE_OS_TYPE);
    }

}
