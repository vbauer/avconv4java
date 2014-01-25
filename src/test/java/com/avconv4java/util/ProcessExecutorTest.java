package com.avconv4java.util;

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
        Assert.assertEquals(runCommand(COMMAND_LS, 30000L), ProcessExecutor.EXIT_CODE_SUCCESS);
        Assert.assertNotEquals(runCommand(COMMAND_SLEEP, 1L), ProcessExecutor.EXIT_CODE_SUCCESS);
    }

    public void testNixCommandWithoutTimeout() throws Exception {
        Assert.assertEquals(runCommand(COMMAND_LS, null), ProcessExecutor.EXIT_CODE_SUCCESS);
    }


    private int runCommand(final List<String> command, final Long timeout) throws Exception {
        return ProcessExecutor.execute(command, timeout, false);
    }

}
