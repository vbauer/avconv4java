package com.avconv4java.model;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.UUID;

/**
 * @author Vladislav Bauer
 */

@Test
public class ModelTest {

    private static final String FAKE_VALUE = UUID.randomUUID().toString();


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

}
