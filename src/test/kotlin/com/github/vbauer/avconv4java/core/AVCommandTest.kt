package com.github.vbauer.avconv4java.core

import org.hamcrest.MatcherAssert.assertThat
import org.hamcrest.Matchers.*
import org.testng.Assert.fail
import org.testng.annotations.Test

/**
 * @author Vladislav Bauer
 */

class AVCommandTest {

    @Test
    fun testGlobalMethods() {
        assertThat(AVCommand.getDefaultToolPath(), notNullValue())
        assertThat(AVCommand.setGlobalToolPath(null), nullValue())
        assertThat(AVCommand.getGlobalToolPath(), nullValue())
    }

    @Test
    fun testGettersAndSetters() {
        val command = createCommand()

        assertThat(command.isDebug, equalTo(false))
        assertThat(command.timeout, equalTo(1L))
        assertThat(command.toolPath, nullValue())
    }

    @Test
    fun testCalculateToolPath() {
        val command = createCommand()

        AVCommand.setGlobalToolPath(null)
        assertThat(command.calculateToolPath(), nullValue())
    }

    @Test(expectedExceptions = [NullPointerException::class])
    fun test() {
        AVCommand.setGlobalToolPath(null)

        val command = createCommand()
        fail(command.run(AVOptions.create()).toString())
    }


    /*
     * Internal API.
     */

    private fun createCommand(): AVCommand {
        return AVCommand()
                .setDebug(false)
                .setTimeout(1L)
                .setToolPath(null)
    }

}
