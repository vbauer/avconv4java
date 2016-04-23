package com.github.vbauer.avconv4java.core;

import org.testng.annotations.Test;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.notNullValue;
import static org.hamcrest.Matchers.nullValue;
import static org.testng.Assert.fail;

/**
 * @author Vladislav Bauer
 */

public class AVCommandTest {

    @Test
    public void testGlobalMethods() {
        assertThat(AVCommand.getDefaultToolPath(), notNullValue());
        assertThat(AVCommand.setGlobalToolPath(null), nullValue());
        assertThat(AVCommand.getGlobalToolPath(), nullValue());
    }

    @Test
    public void testGettersAndSetters() {
        final AVCommand command = createCommand();

        assertThat(command.isDebug(), equalTo(false));
        assertThat(command.getTimeout(), equalTo(1L));
        assertThat(command.getToolPath(), nullValue());
    }

    @Test
    public void testCalculateToolPath() {
        final AVCommand command = createCommand();
        AVCommand.setGlobalToolPath(null);
        assertThat(command.calculateToolPath(), nullValue());
    }

    @Test(expectedExceptions = NullPointerException.class)
    public void test() throws Exception {
        AVCommand.setGlobalToolPath(null);
        final AVCommand command = createCommand();
        fail(command.run(AVOptions.create()).toString());
    }


    /*
     * Internal API.
     */

    private AVCommand createCommand() {
        return new AVCommand()
            .setDebug(false)
            .setTimeout(1L)
            .setToolPath(null);
    }

}
