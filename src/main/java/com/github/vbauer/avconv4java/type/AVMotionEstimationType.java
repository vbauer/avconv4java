package com.github.vbauer.avconv4java.type;

import com.github.vbauer.avconv4java.util.AVUtils;

/**
 * @author Vladislav Bauer
 */

public enum AVMotionEstimationType implements NamedType {

    /**
     * Zero motion estimation (fastest).
     */
    ZERO(Constants.ZERO),

    /**
     * Full motion estimation (slowest).
     */
    FULL(Constants.FULL),

    /**
     * EPZS motion estimation (default).
     */
    EPZS(Constants.EPZS),

    /**
     * Esa motion estimation (alias for full).
     */
    ESA(Constants.ESA),

    /**
     * Tesa motion estimation.
     */
    TESA(Constants.TESA),

    /**
     * Diamond motion estimation (alias for EPZS).
     */
    DIA(Constants.DIA),

    /**
     * Log motion estimation.
     */
    LOG(Constants.LOG),

    /**
     * Phods motion estimation.
     */
    PHODS(Constants.PHODS),

    /**
     * X1 motion estimation.
     */
    X1(Constants.X1),

    /**
     * Hex motion estimation.
     */
    HEX(Constants.HEX),

    /**
     * Umh motion estimation.
     */
    UMH(Constants.UMH);


    private final String name;


    AVMotionEstimationType(final String name) {
        this.name = name;
    }


    @Override
    public String getName() {
        return name;
    }


    public static AVMotionEstimationType findByName(final String name) {
        return AVUtils.findByName(AVMotionEstimationType.class, name);
    }


    /**
     * @author Vladislav Bauer
     */

    public static final class Constants {

        public static final String ZERO = "zero";
        public static final String FULL = "full";
        public static final String EPZS = "epzs";
        public static final String ESA = "esa";
        public static final String TESA = "tesa";
        public static final String DIA = "dia";
        public static final String LOG = "log";
        public static final String PHODS = "phods";
        public static final String X1 = "x1";
        public static final String HEX = "hex";
        public static final String UMH = "umh";


        private Constants() {
            throw new UnsupportedOperationException();
        }

    }

}
