package com.avconv4java.core;

import com.avconv4java.model.AVAudioCodecType;
import com.avconv4java.model.AVMovFlagsType;
import com.avconv4java.model.AVVideoCodecType;
import com.avconv4java.option.AVAudioOptions;
import com.avconv4java.option.AVCodecOptions;
import com.avconv4java.option.AVMainOptions;
import com.avconv4java.option.AVVideoOptions;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * @author Vladislav Bauer
 */

@Test
public class AVOptionsTest {

    public void testCombineOptions() {
        final AVOptions options = AVOptions.create("input.avi", "output.mp4")
            .builders(
                AVMainOptions.create()
                    .overwriteOutput(),
                AVVideoOptions.create()
                    .proportionalResizeUsingWidth(800)
                    .videoCodec(AVVideoCodecType.H264)
                    .movFlags(AVMovFlagsType.FAST_START),
                AVAudioOptions.create()
                    .audioCodec(AVAudioCodecType.VISUAL_ON_AAC)
                    .audioBitRate(128)
                    .audioChannelsCount(2)
                    .sampleRate(11025),
                AVCodecOptions.create()
                    .bitRate(1000)
            );

        final String flags = options.toString();
        Assert.assertEquals(flags,
            "-i input.avi -y -vf scale=w=800:h=trunc(ow/a/2)*2 -vcodec libx264 -movflags faststart "
            + "-acodec libvo_aacenc -ab 128k -ac 2 -ar 11025 -b 1000k output.mp4"
        );
    }

}
