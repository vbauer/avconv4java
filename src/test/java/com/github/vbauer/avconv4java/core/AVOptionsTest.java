package com.github.vbauer.avconv4java.core;

import com.github.vbauer.avconv4java.option.AVAudioOptions;
import com.github.vbauer.avconv4java.option.AVCodecOptions;
import com.github.vbauer.avconv4java.option.AVGenericOptions;
import com.github.vbauer.avconv4java.option.AVMainOptions;
import com.github.vbauer.avconv4java.option.AVVideoOptions;
import com.github.vbauer.avconv4java.type.AVAudioCodecType;
import com.github.vbauer.avconv4java.type.AVLogLevelType;
import com.github.vbauer.avconv4java.type.AVMovFlagsType;
import com.github.vbauer.avconv4java.type.AVVideoCodecType;
import com.github.vbauer.avconv4java.util.AVUtils;
import org.testng.annotations.Test;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.notNullValue;
import static org.testng.Assert.fail;

/**
 * @author Vladislav Bauer
 */

public class AVOptionsTest {

    private static final String INPUT_FILE = "input.avi";
    private static final String OUTPUT_FILE = "output.mp4";

    private static final String OPTION_FLAGS = "-i " + INPUT_FILE + "%s" + OUTPUT_FILE;
    private static final String GENERIC_FLAGS = "-loglevel info";
    private static final String MAIN_FLAGS = "-y";
    private static final String VIDEO_FLAGS = "-vf scale=w=800:h=trunc(ow/a/2)*2 -vcodec libx264 -movflags faststart";
    private static final String AUDIO_FLAGS = "-acodec libvo_aacenc -ab 128k -ac 2 -ar 11025";
    private static final String CODEC_FLAGS = "-b 1000k";

    private static final String COMBINED_FLAGS = String.format(OPTION_FLAGS,
        AVUtils.SPACE + AVUtils.join(GENERIC_FLAGS, MAIN_FLAGS, VIDEO_FLAGS, AUDIO_FLAGS, CODEC_FLAGS) + AVUtils.SPACE
    );


    @Test
    public void testCreate() {
        assertThat(AVOptions.create(), notNullValue());
    }

    @Test(expectedExceptions = IllegalArgumentException.class)
    public void testBuilders() {
        fail(AVOptions.create().builders(AVRootOptions.create("", "")).build().toString());
    }

    @Test
    public void testCombineOptions() {
        final AVRootOptions options = createOptions();
        assertThat(options.toString(), equalTo(String.format(OPTION_FLAGS, AVUtils.SPACE)));

        final AVGenericOptions genericOptions = createGenericOptions();
        assertThat(genericOptions.toString(), equalTo(GENERIC_FLAGS));

        final AVMainOptions mainOptions = createMainOptions();
        assertThat(mainOptions.toString(), equalTo(MAIN_FLAGS));

        final AVVideoOptions videoOptions = createVideoOptions();
        assertThat(videoOptions.toString(), equalTo(VIDEO_FLAGS));

        final AVAudioOptions audioOptions = createAudioOptions();
        assertThat(audioOptions.toString(), equalTo(AUDIO_FLAGS));

        final AVCodecOptions codecOptions = createCodecOptions();
        assertThat(codecOptions.toString(), equalTo(CODEC_FLAGS));

        final AVOptions combinedOptions = options.builders(
            genericOptions, mainOptions, videoOptions, audioOptions, codecOptions
        );
        assertThat(combinedOptions.toString(), equalTo(COMBINED_FLAGS));
    }


    /*
     * Internal API.
     */

    private AVRootOptions createOptions() {
        return AVRootOptions.create(INPUT_FILE, OUTPUT_FILE);
    }

    private AVGenericOptions createGenericOptions() {
        return AVGenericOptions.create()
            .logLevel(AVLogLevelType.INFO);
    }

    private AVCodecOptions createCodecOptions() {
        return AVCodecOptions.create()
            .bitRate(1000);
    }

    private AVAudioOptions createAudioOptions() {
        return AVAudioOptions.create()
            .audioCodec(AVAudioCodecType.VISUAL_ON_AAC)
            .audioBitRate(128)
            .audioChannelsCount(2)
            .sampleRate(11025);
    }

    private AVVideoOptions createVideoOptions() {
        return AVVideoOptions.create()
            .proportionalResizeUsingWidth(800)
            .videoCodec(AVVideoCodecType.H264)
            .movFlags(AVMovFlagsType.FAST_START);
    }

    private AVMainOptions createMainOptions() {
        return AVMainOptions.create()
            .overwriteOutput();
    }

}
