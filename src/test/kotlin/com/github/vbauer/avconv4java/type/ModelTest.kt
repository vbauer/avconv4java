package com.github.vbauer.avconv4java.type

import com.github.vbauer.avconv4java.util.AVUtils
import org.hamcrest.MatcherAssert.assertThat
import org.hamcrest.Matchers.*
import org.testng.annotations.Test
import java.lang.reflect.Method
import java.util.*

/**
 * @author Vladislav Bauer
 */

class ModelTest {

    @Test
    fun testModelTypes() {
        makeBasicCheck(AVAudioCodecType.Constants.AAC, AVAudioCodecType.AAC)
        makeBasicCheck(AVCodecFlagType.Constants.AIC, AVCodecFlagType.AIC)
        makeBasicCheck(AVDebugInfoType.Constants.ER, AVDebugInfoType.ER)
        makeBasicCheck(AVErrorDetectionType.Constants.BUFFER, AVErrorDetectionType.BUFFER)
        makeBasicCheck(AVFileFormatType.Constants.CRC, AVFileFormatType.CRC)
        makeBasicCheck(AVFormatDebugInfoType.Constants.TS, AVFormatDebugInfoType.TS)
        makeBasicCheck(AVFormatFlagType.Constants.NO_BUFFER, AVFormatFlagType.NO_BUFFER)
        makeBasicCheck(AVHardwareAccelerationType.Constants.VDPAU, AVHardwareAccelerationType.VDPAU)
        makeBasicCheck(AVLogLevelType.Constants.INFO, AVLogLevelType.INFO)
        makeBasicCheck(AVMotionEstimationType.Constants.LOG, AVMotionEstimationType.LOG)
        makeBasicCheck(AVMovFlagsType.Constants.FAST_START, AVMovFlagsType.FAST_START)
        makeBasicCheck(AVStreamType.Constants.AUDIO, AVStreamType.AUDIO)
        makeBasicCheck(AVStrictType.Constants.VERY, AVStrictType.VERY)
        makeBasicCheck(AVTargetFileType.Constants.DV, AVTargetFileType.DV)
        makeBasicCheck(AVVideoCodecType.Constants.H264, AVVideoCodecType.H264)
        makeBasicCheck(AVVideoSyncType.Constants.CFR, AVVideoSyncType.CRF)
        makeBasicCheck(AVVideoSizeType.Constants.VGA, AVVideoSizeType.VGA)

        for (type in AVVideoSizeType.values()) {
            assertThat(type.width, greaterThan(0))
            assertThat(type.height, greaterThan(0))
        }
    }

    @Suppress("UNCHECKED_CAST")
    private fun makeBasicCheck(choiceName: String, choice: Any) {
        val findByName = findMethod(choice, METHOD_FIND_BY_NAME, String::class.java)
        assertThat(findByName.invoke(null, choiceName), equalTo(choice))
        assertThat(findByName.invoke(null, FAKE_VALUE), nullValue())
        assertThat(findByName.invoke(null, AVUtils.EMPTY), nullValue())
        assertThat(findByName.invoke(null, null as String?), nullValue())

        val valuesMethod = findMethod(choice, METHOD_VALUES)
        val values = valuesMethod.invoke(null)!! as Array<Any>

        for (value in values) {
            val method = findMethod(value, METHOD_GET_NAME)
            val name = method.invoke(value) as String
            assertThat(AVUtils.isBlank(name), equalTo(false))
        }
    }

    private fun findMethod(obj: Any, name: String, vararg paramTypes: Class<*>): Method {
        val entryClass = obj.javaClass
        return entryClass.getDeclaredMethod(name, *paramTypes)
    }

    companion object {
        private val FAKE_VALUE = "FAKE_" + UUID.randomUUID().toString()

        private const val METHOD_FIND_BY_NAME = "findByName"
        private const val METHOD_VALUES = "values"
        private const val METHOD_GET_NAME = "getName"
    }

}
