package com.github.vbauer.avconv4java.option

import com.github.vbauer.avconv4java.type.AVFileFormatType
import com.github.vbauer.avconv4java.type.AVStreamType
import com.github.vbauer.avconv4java.type.AVTargetFileType
import org.hamcrest.MatcherAssert.assertThat
import org.hamcrest.Matchers.emptyIterable
import org.hamcrest.Matchers.not
import org.testng.annotations.Test
import org.testng.collections.Lists

/**
 * @author Vladislav Bauer
 */

class AVMainOptionsTest {

    @Test
    fun testSmokeAVMainOptions() {
        val options = AVMainOptions.create()
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
                .inputTimeOffset(1.0)
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
                .build()

        assertThat(options, not(emptyIterable()))
    }

}
