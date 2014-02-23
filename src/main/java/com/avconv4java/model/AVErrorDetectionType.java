package com.avconv4java.model;

/**
 * @author Vladislav Bauer
 */

public enum AVErrorDetectionType {

    /**
     * Verify embedded CRCs.
     */
    CRC_CHECK("crccheck"),

    /**
     * Detect bitstream specification deviations.
     */
    BIT_STREAM("bitstream"),

    /**
     * Detect improper bitstream length.
     */
    BUFFER("buffer"),

    /**
     * Abort decoding on minor error detection.
     */
    EXPLODE("explode");


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

}
