package com.github.vbauer.avconv4java.option;

import com.github.vbauer.avconv4java.type.*;
import org.testng.annotations.Test;
import org.testng.collections.Lists;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.emptyIterable;
import static org.hamcrest.Matchers.not;

/**
 * @author Vladislav Bauer
 */

public class AVCodecOptionsTest {

    @Test
    public void testSmokeAVCodecOptions() {
        final List<String> options = AVCodecOptions.create()
            .bitRate(AVStreamType.AUDIO, 1)
            .bitRate(1)
            .codecFlags(AVStreamType.AUDIO, AVCodecFlagType.AIC)
            .codecFlags(AVCodecFlagType.AIC)
            .codecFlags(AVStreamType.AUDIO, AVCodecFlagType.AIC.getName())
            .codecFlags(AVCodecFlagType.AIC.getName())
            .cutOffBandwidth(AVStreamType.AUDIO, 1)
            .cutOffBandwidth(1)
            .debug(AVDebugInfoType.MB_TYPE)
            .debug(AVDebugInfoType.MB_TYPE.getName())
            .frameSize(AVStreamType.AUDIO, 1)
            .frameSize(1)
            .groupOfPictures(AVStreamType.AUDIO, 1)
            .groupOfPictures(1)
            .motionEstimationMethod(AVMotionEstimationType.DIA)
            .motionEstimationMethod(AVMotionEstimationType.DIA.getName())
            .motionEstimationMethod(AVStreamType.AUDIO, AVMotionEstimationType.DIA)
            .motionEstimationMethod(AVStreamType.AUDIO, AVMotionEstimationType.DIA.getName())
            .preset(AVStreamType.AUDIO, "fileName")
            .strict(AVStrictType.STRICT)
            .strict(AVStrictType.STRICT.getName())
            .videoBitRateTolerance(AVStreamType.AUDIO, 1)
            .videoBitRateTolerance(1)
            .builders(Lists.newArrayList())
            .builders()
            .flags(Lists.newArrayList())
            .flags()
            .build();

        assertThat(options, not(emptyIterable()));
    }

}
