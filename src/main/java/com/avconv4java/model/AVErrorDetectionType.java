package com.avconv4java.model;

/**
 * @author Vladislav Bauer
 */

public enum AVErrorDetectionType {

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


    private AVErrorDetectionType(final String name) {
        this.name = name;
    }


    public String getName() {
        return name;
    }


    public static AVErrorDetectionType findByName(final String name) {
        for (final AVErrorDetectionType type : values()) {
            if (type.getName().equalsIgnoreCase(name)) {
                return type;
            }
        }
        return null;
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
