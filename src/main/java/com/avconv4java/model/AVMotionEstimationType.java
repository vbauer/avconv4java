package com.avconv4java.model;

/**
 * @author Vladislav Bauer
 */

public enum AVMotionEstimationType {

    /**
     * Zero motion estimation (fastest).
     */
    ZERO("zero"),

    /**
     * Full motion estimation (slowest).
     */
    FULL("full"),

    /**
     * EPZS motion estimation (default).
     */
    EPZS("epzs"),

    /**
     * Esa motion estimation (alias for full).
     */
    ESA("esa"),

    /**
     * Tesa motion estimation.
     */
    TESA("tesa"),

    /**
     * Diamond motion estimation (alias for EPZS).
     */
    DIA("dia"),

    /**
     * Log motion estimation.
     */
    LOG("log"),

    /**
     * Phods motion estimation.
     */
    PHODS("phods"),

    /**
     * X1 motion estimation.
     */
    X1("x1"),

    /**
     * Hex motion estimation.
     */
    HEX("hex"),

    /**
     * Umh motion estimation.
     */
    UMH("umh");


    private final String name;


    private AVMotionEstimationType(final String name) {
        this.name = name;
    }


    public String getName() {
        return name;
    }


    public static AVMotionEstimationType findByName(final String name) {
        for (final AVMotionEstimationType type : values()) {
            if (type.getName().equalsIgnoreCase(name)) {
                return type;
            }
        }
        return null;
    }

}
