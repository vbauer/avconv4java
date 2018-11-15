package com.github.vbauer.avconv4java.type

import com.github.vbauer.avconv4java.common.TestUtils
import org.testng.Assert
import org.testng.annotations.DataProvider
import org.testng.annotations.Factory
import org.testng.annotations.Test

/**
 * @author Vladislav Bauer
 */

class TypeTest {

    @DataProvider
    fun data(): Array<Array<out Class<out Any>>> {
        return arrayOf(
                arrayOf(AVCodecFlagType.Constants::class.java),
                arrayOf(AVDebugInfoType.Constants::class.java),
                arrayOf(AVErrorDetectionType.Constants::class.java),
                arrayOf(AVAudioCodecType.Constants::class.java),
                arrayOf(AVFileFormatType.Constants::class.java),
                arrayOf(AVFormatDebugInfoType.Constants::class.java),
                arrayOf(AVFormatFlagType.Constants::class.java),
                arrayOf(AVHardwareAccelerationType.Constants::class.java),
                arrayOf(AVLogLevelType.Constants::class.java),
                arrayOf(AVMotionEstimationType.Constants::class.java),
                arrayOf(AVMovFlagsType.Constants::class.java),
                arrayOf(AVStreamType.Constants::class.java),
                arrayOf(AVStrictType.Constants::class.java),
                arrayOf(AVTargetFileType.Constants::class.java),
                arrayOf(AVVideoCodecType.Constants::class.java),
                arrayOf(AVVideoSizeType.Constants::class.java),
                arrayOf(AVVideoSyncType.Constants::class.java)
        )
    }

    @Factory(dataProvider = "data")
    fun createTest(utilClass: Class<*>): Array<Any> {
        return arrayOf(TypeConstructorTest(utilClass))
    }


    /**
     * @author Vladislav Bauer
     */
    class TypeConstructorTest internal constructor(private val utilClass: Class<*>) : Assert() {

        @Test
        fun testConstructorContract() {
            TestUtils.checkUtilClassConstructor(utilClass)
        }
    }

}
