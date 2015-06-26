package com.github.vbauer.avconv4java.core;

import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * @author Vladislav Bauer
 */

public class AVCommandTest {

    @Test
    public void testGlobalMethods() {
        Assert.assertNotNull(AVCommand.getDefaultToolPath());
        Assert.assertNull(AVCommand.setGlobalToolPath(null));
        Assert.assertNull(AVCommand.getGlobalToolPath());
    }

    @Test
    public void testGettersAndSetters() {
        final AVCommand command = createCommand();

        Assert.assertFalse(command.isDebug());
        Assert.assertEquals(command.getTimeout().longValue(), 1L);
        Assert.assertNull(command.getToolPath());
    }

    @Test
    public void testCalculateToolPath() {
        final AVCommand command = createCommand();
        AVCommand.setGlobalToolPath(null);
        Assert.assertNull(command.calculateToolPath());
    }

    @Test(expectedExceptions = NullPointerException.class)
    public void test() throws Exception {
        AVCommand.setGlobalToolPath(null);

        final AVCommand command = createCommand();
        Assert.fail(command.run(AVOptions.create()).toString());
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
