package com.avconv4java.util;

import com.avconv4java.util.process.ProcessExecutor;
import com.avconv4java.util.process.ProcessInfo;
import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;

/**
 * @author Vladislav Bauer
 */

@Test
public class ProcessExecutorTest {

    private static final List<String> COMMAND_LS = Arrays.asList("ls");
    private static final List<String> COMMAND_SLEEP = Arrays.asList("sleep", "1");


    @BeforeClass
    public void init() {
        if (!AVUtils.isUnix()) {
            throw new SkipException("Test is only for Unix OS");
        }
    }


    public void testNixCommandWithTimeout() throws Exception {
        Assert.assertTrue(runCommand(COMMAND_LS, 30000L, false).isSuccess());
        Assert.assertTrue(runCommand(COMMAND_SLEEP, 1L, false).isError());

        Assert.assertTrue(runCommand(COMMAND_LS, 30000L, true).isSuccess());
        Assert.assertTrue(runCommand(COMMAND_SLEEP, 1L, true).isError());
    }

    public void testNixCommandWithoutTimeout() throws Exception {
        Assert.assertTrue(runCommand(COMMAND_LS, null, false).isSuccess());
        Assert.assertTrue(runCommand(COMMAND_LS, null, true).isSuccess());
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

}
