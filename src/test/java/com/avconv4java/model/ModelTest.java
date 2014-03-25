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


    public void testAVAudioCodecType() throws Exception {
        makeBasicCheck(AVAudioCodecType.Constants.AAC, AVAudioCodecType.AAC);
    }

    public void testAVCodecFlagType() throws Exception {
        makeBasicCheck(AVCodecFlagType.Constants.AIC, AVCodecFlagType.AIC);
    }

    public void testAVDebugInfoType() throws Exception {
        makeBasicCheck(AVDebugInfoType.Constants.ER, AVDebugInfoType.ER);
    }

    public void testAVErrorDetectionType() throws Exception {
        makeBasicCheck(AVErrorDetectionType.Constants.BUFFER, AVErrorDetectionType.BUFFER);
    }

    public void testAVFileFormatType() throws Exception {
        makeBasicCheck(AVFileFormatType.Constants.CRC, AVFileFormatType.CRC);
    }

    public void testAVFormatDebugInfoType() throws Exception {
        makeBasicCheck(AVFormatDebugInfoType.Constants.TS, AVFormatDebugInfoType.TS);
    }

    public void testAVFormatFlagType() throws Exception {
        makeBasicCheck(AVFormatFlagType.Constants.NO_BUFFER, AVFormatFlagType.NO_BUFFER);
    }

    public void testAVHardwareAccelerationType() throws Exception {
        makeBasicCheck(AVHardwareAccelerationType.Constants.VDPAU, AVHardwareAccelerationType.VDPAU);
    }

    public void testAVLogLevelType() throws Exception {
        makeBasicCheck(AVLogLevelType.Constants.INFO, AVLogLevelType.INFO);
    }

    public void testAVMotionEstimationType() throws Exception {
        makeBasicCheck(AVMotionEstimationType.Constants.LOG, AVMotionEstimationType.LOG);
    }

    public void testAVMovFlagsType() throws Exception {
        makeBasicCheck(AVMovFlagsType.Constants.FAST_START, AVMovFlagsType.FAST_START);
    }

    public void testAVStreamType() throws Exception {
        makeBasicCheck(AVStreamType.Constants.AUDIO, AVStreamType.AUDIO);
    }

    public void testAVStrictType() throws Exception {
        makeBasicCheck(AVStrictType.Constants.VERY, AVStrictType.VERY);
    }

    public void testAVTargetFileType() throws Exception {
        makeBasicCheck(AVTargetFileType.Constants.DV, AVTargetFileType.DV);
    }

    public void testAVVideoCodecType() throws Exception {
        makeBasicCheck(AVVideoCodecType.Constants.H264, AVVideoCodecType.H264);
    }

    public void testAVVideoSizeType() throws Exception {
        makeBasicCheck(AVVideoSizeType.Constants.VGA, AVVideoSizeType.VGA);
        for (final AVVideoSizeType type : AVVideoSizeType.values()) {
            Assert.assertTrue(type.getWidth() > 0);
            Assert.assertTrue(type.getHeight() > 0);
        }
    }

    public void testAVVideoSyncType() throws Exception {
        makeBasicCheck(AVVideoSyncType.Constants.CFR, AVVideoSyncType.CRF);
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
