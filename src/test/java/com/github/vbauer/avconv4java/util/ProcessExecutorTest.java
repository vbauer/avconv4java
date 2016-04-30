package com.github.vbauer.avconv4java.util;

import java.lang.reflect.Method;
import java.util.List;
import java.util.concurrent.ExecutorService;

import com.github.vbauer.avconv4java.common.TestUtils;
import com.github.vbauer.avconv4java.util.process.ProcessExecutor;
import com.github.vbauer.avconv4java.util.process.ProcessInfo;
import org.testng.SkipException;
import org.testng.annotations.Test;
import org.testng.collections.Lists;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.not;
import static org.hamcrest.Matchers.nullValue;

/**
 * @author Vladislav Bauer
 */

public class ProcessExecutorTest {

    private static final String MESSAGE_OS_TYPE = "Test is only for Solaris, Unix, Windows and Mac";


    @Test
    public void testConstructorContract() throws Throwable {
        TestUtils.checkUtilClassConstructor(ProcessExecutor.class);
    }

    @Test
    public void testNixCommandWithEnoughTimeout() throws Throwable {
        final List<String> command = getDirListCmd();
        assertThat(runCommand(command, 30000L, false).isSuccess(), equalTo(true));
        assertThat(runCommand(command, 30000L, true).isSuccess(), equalTo(true));
    }

    @Test
    public void testNixCommandWithNotEnoughTimeout() throws Throwable {
        final List<String> command = getSleepCmd();
        assertThat(runCommand(command, 1L, false).isError(), equalTo(true));
        assertThat(runCommand(command, 1L, true).isError(), equalTo(true));
    }

    @Test
    public void testNixCommandWithoutTimeout() throws Throwable {
        final List<String> command = getDirListCmd();
        assertThat(runCommand(command, null, false).isSuccess(), equalTo(true));
        assertThat(runCommand(command, null, true).isSuccess(), equalTo(true));
    }

    @Test
    public void testErrorProcessInfo() {
        final ProcessInfo info = ProcessInfo.error(MESSAGE_OS_TYPE);
        assertThat(info.isError(), equalTo(true));
        assertThat(info.isSuccess(), equalTo(false));
        assertThat(info.getOutput(), nullValue());
        assertThat(info.getErrorOutput(), equalTo(MESSAGE_OS_TYPE));
    }

    @Test
    public void testCorrectProcessInfo() {
        final ProcessInfo info = ProcessInfo.create(ProcessInfo.EXIT_CODE_SUCCESS, MESSAGE_OS_TYPE, null);
        assertThat(info.isError(), equalTo(false));
        assertThat(info.isSuccess(), equalTo(true));
        assertThat(info.getErrorOutput(), nullValue());
        assertThat(info.getOutput(), equalTo(MESSAGE_OS_TYPE));
    }

    @Test
    public void testShutdownExecutor() throws Exception {
        final Method method = ProcessExecutor.class.getDeclaredMethod("shutdownExecutor", ExecutorService.class);
        method.setAccessible(true);

        assertThat((Boolean) method.invoke(null, new Object[] { null }), equalTo(false));
    }


    /*
     * Internal API.
     */

    private ProcessInfo runCommand(final List<String> command, final Long timeout, boolean debug) throws Exception {
        final ProcessInfo processInfo = ProcessExecutor.execute(command, timeout, debug);
        final int statusCode = processInfo.getStatusCode();
        final String errorOutput = AVUtils.trimToNull(processInfo.getErrorOutput());
        if (errorOutput != null) {
            assertThat(statusCode, not(equalTo(ProcessInfo.EXIT_CODE_SUCCESS)));
        }
        return processInfo;
    }

    private List<String> getDirListCmd() {
        if (couldHaveBash()) {
            return Lists.newArrayList("ls");
        } else if (AVUtils.isWindows()) {
            return Lists.newArrayList("CMD", "/C", "DIR");
        }
        throw new SkipException(MESSAGE_OS_TYPE);
    }

    private List<String> getSleepCmd() {
        if (couldHaveBash()) {
            return Lists.newArrayList("sleep", "1");
        }
        // XXX: Test is not run on Windows, because OS does not have command "sleep".
        throw new SkipException(MESSAGE_OS_TYPE);
    }

    private boolean couldHaveBash() {
        final boolean mac = AVUtils.isMac();
        final boolean solaris = AVUtils.isSolaris();
        final boolean unix = AVUtils.isUnix();

        return mac || solaris || unix;
    }

}
