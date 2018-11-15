package com.github.vbauer.avconv4java.core

import com.github.vbauer.avconv4java.option.*
import com.github.vbauer.avconv4java.type.AVAudioCodecType
import com.github.vbauer.avconv4java.type.AVLogLevelType
import com.github.vbauer.avconv4java.type.AVMovFlagsType
import com.github.vbauer.avconv4java.type.AVVideoCodecType
import com.github.vbauer.avconv4java.util.AVUtils
import org.hamcrest.MatcherAssert.assertThat
import org.hamcrest.Matchers.equalTo
import org.hamcrest.Matchers.notNullValue
import org.testng.Assert.fail
import org.testng.annotations.Test

/**
 * @author Vladislav Bauer
 */

class AVOptionsTest {

    @Test
    fun testCreate() {
        assertThat(AVOptions.create(), notNullValue())
    }

    @Test(expectedExceptions = [IllegalArgumentException::class])
    fun testBuilders() {
        fail(AVOptions.create().builders(AVRootOptions.create("", "")).build().toString())
    }

    @Test
    fun testCombineOptions() {
        val options = createOptions()
        assertThat(options.toString(), equalTo(java.lang.String.format(OPTION_FLAGS, AVUtils.SPACE)))

        val genericOptions = createGenericOptions()
        assertThat(genericOptions.toString(), equalTo(GENERIC_FLAGS))

        val mainOptions = createMainOptions()
        assertThat(mainOptions.toString(), equalTo(MAIN_FLAGS))

        val videoOptions = createVideoOptions()
        assertThat(videoOptions.toString(), equalTo(VIDEO_FLAGS))

        val audioOptions = createAudioOptions()
        assertThat(audioOptions.toString(), equalTo(AUDIO_FLAGS))

        val codecOptions = createCodecOptions()
        assertThat(codecOptions.toString(), equalTo(CODEC_FLAGS))

        val combinedOptions = options.builders(
                genericOptions, mainOptions, videoOptions, audioOptions, codecOptions
        )
        assertThat(combinedOptions.toString(), equalTo(COMBINED_FLAGS))
    }


    /*
     * Internal API.
     */

    private fun createOptions(): AVRootOptions {
        return AVRootOptions.create(INPUT_FILE, OUTPUT_FILE)
    }

    private fun createGenericOptions(): AVGenericOptions {
        return AVGenericOptions.create()
                .logLevel(AVLogLevelType.INFO)
    }

    private fun createCodecOptions(): AVCodecOptions {
        return AVCodecOptions.create()
                .bitRate(1000)
    }

    private fun createAudioOptions(): AVAudioOptions {
        return AVAudioOptions.create()
                .audioCodec(AVAudioCodecType.VISUAL_ON_AAC)
                .audioBitRate(128)
                .audioChannelsCount(2)
                .sampleRate(11025)
    }

    private fun createVideoOptions(): AVVideoOptions {
        return AVVideoOptions.create()
                .proportionalResizeUsingWidth(800)
                .videoCodec(AVVideoCodecType.H264)
                .movFlags(AVMovFlagsType.FAST_START)
    }

    private fun createMainOptions(): AVMainOptions {
        return AVMainOptions.create()
                .overwriteOutput()
    }

    companion object {
        private const val INPUT_FILE = "input.avi"
        private const val OUTPUT_FILE = "output.mp4"

        private const val OPTION_FLAGS = "-i $INPUT_FILE%s$OUTPUT_FILE"
        private const val GENERIC_FLAGS = "-loglevel info"
        private const val MAIN_FLAGS = "-y"
        private const val VIDEO_FLAGS = "-vf scale=w=800:h=trunc(ow/a/2)*2 -vcodec libx264 -movflags faststart"
        private const val AUDIO_FLAGS = "-acodec libvo_aacenc -ab 128k -ac 2 -ar 11025"
        private const val CODEC_FLAGS = "-b 1000k"

        private val COMBINED_FLAGS = java.lang.String.format(OPTION_FLAGS,
                AVUtils.SPACE + AVUtils.join(GENERIC_FLAGS, MAIN_FLAGS, VIDEO_FLAGS, AUDIO_FLAGS, CODEC_FLAGS) + AVUtils.SPACE
        )
    }

}
