package com.github.vbauer.avconv4java.option;

import java.util.List;

import com.github.vbauer.avconv4java.core.AVOptions;
import com.github.vbauer.avconv4java.type.AVAudioCodecType;
import com.github.vbauer.avconv4java.type.AVStreamType;
import org.testng.annotations.Test;
import org.testng.collections.Lists;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.emptyIterable;
import static org.hamcrest.Matchers.not;

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

        assertThat(options, not(emptyIterable()));
    }


}
