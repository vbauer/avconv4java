package com.avconv4java.core;

import com.avconv4java.model.AVAudioCodecType;
import com.avconv4java.model.AVMovFlagsType;
import com.avconv4java.model.AVVideoCodecType;
import com.avconv4java.option.AVAudioOptions;
import com.avconv4java.option.AVCodecOptions;
import com.avconv4java.option.AVMainOptions;
import com.avconv4java.option.AVVideoOptions;
import com.avconv4java.util.AVUtils;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * @author Vladislav Bauer
 */

@Test
public class AVOptionsTest {

    private static final String OPTION_FLAGS = "-i input.avi%soutput.mp4";
    private static final String MAIN_FLAGS = "-y";
    private static final String VIDEO_FLAGS = "-vf scale=w=800:h=trunc(ow/a/2)*2 -vcodec libx264 -movflags faststart";
    private static final String AUDIO_FLAGS = "-acodec libvo_aacenc -ab 128k -ac 2 -ar 11025";
    private static final String CODEC_FLAGS = "-b 1000k";

    private static final String COMBINED_FLAGS = String.format(OPTION_FLAGS,
        AVUtils.SPACE + AVUtils.join(MAIN_FLAGS, VIDEO_FLAGS, AUDIO_FLAGS, CODEC_FLAGS) + AVUtils.SPACE
    );


    public void testCombineOptions() {
        final AVOptions options = createOptions();
        Assert.assertEquals(options.toString(), String.format(OPTION_FLAGS, AVUtils.SPACE));

        final AVMainOptions mainOptions = createMainOptions();
        Assert.assertEquals(mainOptions.toString(), MAIN_FLAGS);

        final AVVideoOptions videoOptions = createVideoOptions();
        Assert.assertEquals(videoOptions.toString(), VIDEO_FLAGS);

        final AVAudioOptions audioOptions = createAudioOptions();
        Assert.assertEquals(audioOptions.toString(), AUDIO_FLAGS);

        final AVCodecOptions codecOptions = createCodecOptions();
        Assert.assertEquals(codecOptions.toString(), CODEC_FLAGS);

        final AVOptions combinedOptions = options.builders(mainOptions, videoOptions, audioOptions, codecOptions);
        Assert.assertEquals(combinedOptions.toString(), COMBINED_FLAGS);
    }


    private AVOptions createOptions() {
        return AVOptions.create("input.avi", "output.mp4");
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
