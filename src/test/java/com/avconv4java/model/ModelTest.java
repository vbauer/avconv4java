package com.avconv4java.model;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.UUID;

/**
 * @author Vladislav Bauer
 */

@Test
public class ModelTest {

    private static final String FAKE_VALUE = "FAKE_" + UUID.randomUUID().toString();


    public void testAVAudioCodecType() {
        Assert.assertEquals(AVAudioCodecType.findByName(AVAudioCodecType.Constants.AAC), AVAudioCodecType.AAC);
        Assert.assertNull(AVAudioCodecType.findByName(FAKE_VALUE));
        Assert.assertNull(AVAudioCodecType.findByName(null));
    }

    public void testAVCodecFlagType() {
        Assert.assertEquals(AVCodecFlagType.findByName(AVCodecFlagType.Constants.AIC), AVCodecFlagType.AIC);
        Assert.assertNull(AVCodecFlagType.findByName(FAKE_VALUE));
        Assert.assertNull(AVCodecFlagType.findByName(null));
    }

    public void testAVDebugInfoType() {
        Assert.assertEquals(AVDebugInfoType.findByName(AVDebugInfoType.Constants.ER), AVDebugInfoType.ER);
        Assert.assertNull(AVDebugInfoType.findByName(FAKE_VALUE));
        Assert.assertNull(AVDebugInfoType.findByName(null));
    }

    public void testAVErrorDetectionType() {
        Assert.assertEquals(
            AVErrorDetectionType.findByName(AVErrorDetectionType.Constants.BUFFER),
            AVErrorDetectionType.BUFFER
        );
        Assert.assertNull(AVErrorDetectionType.findByName(FAKE_VALUE));
        Assert.assertNull(AVErrorDetectionType.findByName(null));
    }

    public void testAVFileFormatType() {
        Assert.assertEquals(AVFileFormatType.findByName(AVFileFormatType.Constants.CRC), AVFileFormatType.CRC);
        Assert.assertNull(AVFileFormatType.findByName(FAKE_VALUE));
        Assert.assertNull(AVFileFormatType.findByName(null));
    }

    public void testAVFormatDebugInfoType() {
        Assert.assertEquals(
            AVFormatDebugInfoType.findByName(AVFormatDebugInfoType.Constants.TS),
            AVFormatDebugInfoType.TS
        );
        Assert.assertNull(AVFormatDebugInfoType.findByName(FAKE_VALUE));
        Assert.assertNull(AVFormatDebugInfoType.findByName(null));
    }

    public void testAVFormatFlagType() {
        Assert.assertEquals(
            AVFormatFlagType.findByName(AVFormatFlagType.Constants.NO_BUFFER),
            AVFormatFlagType.NO_BUFFER
        );
        Assert.assertNull(AVFormatFlagType.findByName(FAKE_VALUE));
        Assert.assertNull(AVFormatFlagType.findByName(null));
    }

    public void testAVHardwareAccelerationType() {
        Assert.assertEquals(
            AVHardwareAccelerationType.findByName(AVHardwareAccelerationType.Constants.VDPAU),
            AVHardwareAccelerationType.VDPAU
        );
        Assert.assertNull(AVHardwareAccelerationType.findByName(FAKE_VALUE));
        Assert.assertNull(AVHardwareAccelerationType.findByName(null));
    }

    public void testAVLogLevelType() {
        Assert.assertEquals(AVLogLevelType.findByName(AVLogLevelType.Constants.INFO), AVLogLevelType.INFO);
        Assert.assertNull(AVLogLevelType.findByName(FAKE_VALUE));
        Assert.assertNull(AVLogLevelType.findByName(null));
    }

    public void testAVMotionEstimationType() {
        Assert.assertEquals(
            AVMotionEstimationType.findByName(AVMotionEstimationType.Constants.LOG),
            AVMotionEstimationType.LOG
        );
        Assert.assertNull(AVMotionEstimationType.findByName(FAKE_VALUE));
        Assert.assertNull(AVMotionEstimationType.findByName(null));
    }

    public void testAVMovFlagsType() {
        Assert.assertEquals(AVMovFlagsType.findByName(AVMovFlagsType.Constants.FAST_START), AVMovFlagsType.FAST_START);
        Assert.assertNull(AVMovFlagsType.findByName(FAKE_VALUE));
        Assert.assertNull(AVMovFlagsType.findByName(null));
    }

    public void testAVStreamType() {
        Assert.assertEquals(AVStreamType.findByName(AVStreamType.Constants.AUDIO), AVStreamType.AUDIO);
        Assert.assertNull(AVStreamType.findByName(FAKE_VALUE));
        Assert.assertNull(AVStreamType.findByName(null));
    }

    public void testAVStrictType() {
        Assert.assertEquals(AVStrictType.findByName(AVStrictType.Constants.VERY), AVStrictType.VERY);
        Assert.assertNull(AVStrictType.findByName(FAKE_VALUE));
        Assert.assertNull(AVStrictType.findByName(null));
    }

    public void testAVTargetFileType() {
        Assert.assertEquals(AVTargetFileType.findByName(AVTargetFileType.Constants.DV), AVTargetFileType.DV);
        Assert.assertNull(AVTargetFileType.findByName(FAKE_VALUE));
        Assert.assertNull(AVTargetFileType.findByName(null));
    }

    public void testAVVideoCodecType() {
        Assert.assertEquals(AVVideoCodecType.findByName(AVVideoCodecType.Constants.H264), AVVideoCodecType.H264);
        Assert.assertNull(AVVideoCodecType.findByName(FAKE_VALUE));
        Assert.assertNull(AVVideoCodecType.findByName(null));
    }

}
