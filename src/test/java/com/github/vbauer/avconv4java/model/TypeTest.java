package com.github.vbauer.avconv4java.model;

import com.github.vbauer.avconv4java.common.TestUtils;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Factory;
import org.testng.annotations.Test;

/**
 * @author Vladislav Bauer
 */

public class TypeTest {

    @DataProvider
    public Object[][] data() {
        return new Object[][] {
            { AVCodecFlagType.Constants.class },
            { AVDebugInfoType.Constants.class },
            { AVErrorDetectionType.Constants.class },
            { AVAudioCodecType.Constants.class },
            { AVFileFormatType.Constants.class },
            { AVFormatDebugInfoType.Constants.class },
            { AVFormatFlagType.Constants.class },
            { AVHardwareAccelerationType.Constants.class },
            { AVLogLevelType.Constants.class },
            { AVMotionEstimationType.Constants.class },
            { AVMovFlagsType.Constants.class },
            { AVStreamType.Constants.class },
            { AVStrictType.Constants.class },
            { AVTargetFileType.Constants.class },
            { AVVideoCodecType.Constants.class },
            { AVVideoSizeType.Constants.class },
            { AVVideoSyncType.Constants.class }
        };
    }

    @Factory(dataProvider = "data")
    public Object[] createTest(final Class<?> utilClass) {
        return new Object[] {
            new TypeConstructorTest(utilClass)
        };
    }


    /**
     * @author Vladislav Bauer
     */
    public static class TypeConstructorTest extends Assert {

        private final Class<?> utilClass;

        public TypeConstructorTest(final Class<?> utilClass) {
            this.utilClass = utilClass;
        }

        @Test(expectedExceptions = UnsupportedOperationException.class)
        public void testConstructorContract() throws Throwable {
            TestUtils.checkUtilClassConstructor(utilClass);
        }
    }

}
