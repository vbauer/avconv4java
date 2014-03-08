package com.avconv4java.model;

/**
 * @author Vladislav Bauer
 */

public enum AVDebugInfoType {

    /**
     * Picture info.
     */
    PICT(Constants.PICT),

    /*
     * Rate control.
     */
    RC(Constants.RC),

    /*
     * Macroblock (MB) type.
     */
    BIT_STREAM(Constants.BIT_STREAM),

    MB_TYPE(Constants.MB_TYPE),

    /**
     * Per-block quantization parameter (QP).
     */
    QP(Constants.QP),

    /**
     * Motion vector.
     */
    MV(Constants.MV),

    DCT_COEFF(Constants.DCT_COEFF),

    SKIP(Constants.SKIP),

    START_CODE(Constants.START_CODE),

    PTS(Constants.PTS),

    ER(Constants.ER),

    /**
     * Memory management control operations (H.264).
     */
    MMCO(Constants.MMCO),

    BUGS(Constants.BUGS),

    /**
     * Visualize quantization parameter (QP), lower QP are tinted greener.
     */
    VIS_QP(Constants.VIS_QP),

    /**
     * Visualize block types.
     */
    VIS_MB_TYPE(Constants.VIS_MB_TYPE),

    /**
     * Picture buffer allocations.
     */
    BUFFERS(Constants.BUFFERS),

    /**
     * Threading operations.
     */
    THREAD_OPS(Constants.THREAD_OPS);


    private final String name;


    private AVDebugInfoType(final String name) {
        this.name = name;
    }


    public String getName() {
        return name;
    }


    public static AVDebugInfoType findByName(final String name) {
        for (final AVDebugInfoType type : values()) {
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

        public static final String PICT = "pict";
        public static final String RC = "rc";
        public static final String BIT_STREAM = "bitstream";
        public static final String MB_TYPE = "mb_type";
        public static final String QP = "qp";
        public static final String MV = "mv";
        public static final String DCT_COEFF = "dct_coeff";
        public static final String SKIP = "skip";
        public static final String START_CODE = "startcode";
        public static final String PTS = "pts";
        public static final String ER = "er";
        public static final String MMCO = "mmco";
        public static final String BUGS = "bugs";
        public static final String VIS_QP = "vis_qp";
        public static final String VIS_MB_TYPE = "vis_mb_type";
        public static final String BUFFERS = "buffers";
        public static final String THREAD_OPS = "thread_ops";


        private Constants() {
            throw new UnsupportedOperationException();
        }

    }

}
