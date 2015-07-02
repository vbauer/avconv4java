package com.github.vbauer.avconv4java.option;

import com.beust.jcommander.internal.Lists;
import com.github.vbauer.avconv4java.core.AVOptions;
import com.github.vbauer.avconv4java.type.AVAudioCodecType;
import com.github.vbauer.avconv4java.type.AVStreamType;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

/**
 * @author Vladislav Bauer
 */

public class AVAudioOptionsTest {

    @Test
    public void testSmokeAVAudioOptions() {
        final List<String> options = AVAudioOptions.create()
            .audioBitRate(1)
            .audioChannelsCount(AVStreamType.AUDIO, 1)
            .audioChannelsCount(1)
            .audioCodec(AVAudioCodecType.AAC)
            .audioCodec(AVAudioCodecType.AAC.getName())
            .audioQuality(1.0)
            .disableRecording()
            .filter("filter")
            .flags("flag")
            .framesCount(1L)
            .sampleFormat(AVStreamType.AUDIO, "format")
            .sampleFormat("format")
            .sampleRate(AVStreamType.AUDIO, 1)
            .sampleRate(1)
            .builders(Lists.<AVOptions>newArrayList())
            .builders()
            .flags(Lists.newArrayList())
            .flags()
            .build();

        Assert.assertFalse(options.isEmpty());
    }


}
