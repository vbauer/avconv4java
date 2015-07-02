package com.github.vbauer.avconv4java.type;

import com.github.vbauer.avconv4java.util.AVUtils;

/**
 * @author Vladislav Bauer
 */

public enum AVErrorDetectionType implements NamedType {

    /**
     * Verify embedded CRCs.
     */
    CRC_CHECK(Constants.CRC_CHECK),

    /**
     * Detect bitstream specification deviations.
     */
    BIT_STREAM(Constants.BIT_STREAM),

    /**
     * Detect improper bitstream length.
     */
    BUFFER(Constants.BUFFER),

    /**
     * Abort decoding on minor error detection.
     */
    EXPLODE(Constants.EXPLODE);


    private final String name;


    AVErrorDetectionType(final String name) {
        this.name = name;
    }


    @Override
    public String getName() {
        return name;
    }


    public static AVErrorDetectionType findByName(final String name) {
        return AVUtils.findByName(AVErrorDetectionType.class, name);
    }


    /**
     * @author Vladislav Bauer
     */

    public static final class Constants {

        public static final String CRC_CHECK = "crccheck";
        public static final String BIT_STREAM = "bitstream";
        public static final String BUFFER = "buffer";
        public static final String EXPLODE = "explode";


        private Constants() {
            throw new UnsupportedOperationException();
        }

    }

}
