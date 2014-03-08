package com.avconv4java.model;

import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * @author Vladislav Bauer
 */

@Test
public class ModelTest {

    public void testAVAudioCodecType() {
        Assert.assertEquals(AVAudioCodecType.findByName(AVAudioCodecType.Constants.AAC), AVAudioCodecType.AAC);
        Assert.assertNull(AVAudioCodecType.findByName(null));
    }

}
