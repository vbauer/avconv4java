package com.github.vbauer.avconv4java.option;

import com.github.vbauer.avconv4java.type.AVFileFormatType;
import com.github.vbauer.avconv4java.type.AVStreamType;
import com.github.vbauer.avconv4java.type.AVTargetFileType;
import org.testng.annotations.Test;
import org.testng.collections.Lists;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.emptyIterable;
import static org.hamcrest.Matchers.not;

/**
 * @author Vladislav Bauer
 */

public class AVMainOptionsTest {

    @Test
    public void testSmokeAVMainOptions() {
        final List<String> options = AVMainOptions.create()
            .attachment("fileName")
            .dataFrames(1L)
            .dumpAttachment(AVStreamType.AUDIO, "fileName")
            .dumpAttachment("fileName")
            .duration(1L)
            .duration("duration")
            .fileFormat(AVFileFormatType.CRC)
            .fileFormat(AVFileFormatType.CRC.getName())
            .fileSizeLimit(1L)
            .filter(AVStreamType.AUDIO, "filter")
            .filter("filter")
            .filterScript(AVStreamType.AUDIO, "fileName")
            .filterScript("fileName")
            .framesCount(AVStreamType.AUDIO, 1L)
            .framesCount(1L)
            .immediatelyExit()
            .inputTimeOffset(1.0D)
            .inputTimeOffset("position")
            .metadata("key", "value")
            .overwriteOutput()
            .preset(AVStreamType.AUDIO, "preset")
            .preset("preset")
            .qualityScale(AVStreamType.AUDIO, 1.0)
            .qualityScale(1.0)
            .seek(1.0)
            .seek("position")
            .target(AVTargetFileType.DV)
            .target(AVTargetFileType.DV.getName())
            .builders(Lists.newArrayList())
            .builders()
            .flags(Lists.newArrayList())
            .flags()
            .build();

        assertThat(options, not(emptyIterable()));
    }

}
