package com.avconv4java.model;

import com.avconv4java.util.AVUtils;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.lang.reflect.Method;
import java.util.UUID;

/**
 * @author Vladislav Bauer
 */

@Test
public class ModelTest {

    private static final String FAKE_VALUE = "FAKE_" + UUID.randomUUID().toString();

    private static final String METHOD_FIND_BY_NAME = "findByName";
    private static final String METHOD_VALUES = "values";
    private static final String METHOD_GET_NAME = "getName";


    public void testModelTypes() throws Exception {
        makeBasicCheck(AVAudioCodecType.Constants.AAC, AVAudioCodecType.AAC);
        makeBasicCheck(AVCodecFlagType.Constants.AIC, AVCodecFlagType.AIC);
        makeBasicCheck(AVDebugInfoType.Constants.ER, AVDebugInfoType.ER);
        makeBasicCheck(AVErrorDetectionType.Constants.BUFFER, AVErrorDetectionType.BUFFER);
        makeBasicCheck(AVFileFormatType.Constants.CRC, AVFileFormatType.CRC);
        makeBasicCheck(AVFormatDebugInfoType.Constants.TS, AVFormatDebugInfoType.TS);
        makeBasicCheck(AVFormatFlagType.Constants.NO_BUFFER, AVFormatFlagType.NO_BUFFER);
        makeBasicCheck(AVHardwareAccelerationType.Constants.VDPAU, AVHardwareAccelerationType.VDPAU);
        makeBasicCheck(AVLogLevelType.Constants.INFO, AVLogLevelType.INFO);
        makeBasicCheck(AVMotionEstimationType.Constants.LOG, AVMotionEstimationType.LOG);
        makeBasicCheck(AVMovFlagsType.Constants.FAST_START, AVMovFlagsType.FAST_START);
        makeBasicCheck(AVStreamType.Constants.AUDIO, AVStreamType.AUDIO);
        makeBasicCheck(AVStrictType.Constants.VERY, AVStrictType.VERY);
        makeBasicCheck(AVTargetFileType.Constants.DV, AVTargetFileType.DV);
        makeBasicCheck(AVVideoCodecType.Constants.H264, AVVideoCodecType.H264);
        makeBasicCheck(AVVideoSyncType.Constants.CFR, AVVideoSyncType.CRF);
        makeBasicCheck(AVVideoSizeType.Constants.VGA, AVVideoSizeType.VGA);
        for (final AVVideoSizeType type : AVVideoSizeType.values()) {
            Assert.assertTrue(type.getWidth() > 0);
            Assert.assertTrue(type.getHeight() > 0);
        }
    }


    private void makeBasicCheck(final String choiceName, final Object choice) throws Exception {
        final Method findByName = findMethod(choice, METHOD_FIND_BY_NAME, String.class);
        Assert.assertEquals(findByName.invoke(null, choiceName), choice);
        Assert.assertNull(findByName.invoke(null, FAKE_VALUE));
        Assert.assertNull(findByName.invoke(null, AVUtils.EMPTY));
        Assert.assertNull(findByName.invoke(null, (String) null));

        final Method valuesMethod = findMethod(choice, METHOD_VALUES);
        final Object[] values = (Object[]) valuesMethod.invoke(null);
        for (final Object value : values) {
            final Method method = findMethod(value, METHOD_GET_NAME);
            final String name = (String) method.invoke(value);
            Assert.assertFalse(AVUtils.isBlank(name));
        }
    }

    private Method findMethod(final Object object, final String name, final Class<?>... paramTypes) throws Exception {
        final Class<?> entryClass = object.getClass();
        return entryClass.getDeclaredMethod(name, paramTypes);
    }

}
