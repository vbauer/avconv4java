package com.avconv4java.model;

/**
 * @author Vladislav Bauer
 */

public enum AVDebugInfoType {

    /**
     * Picture info.
     */
    PICT("pict"),

    /*
     * Rate control.
     */
    RC("rc"),

    /*
     * Macroblock (MB) type.
     */
    BIT_STREAM("bitstream"),

    MB_TYPE("mb_type"),

    /**
     * Per-block quantization parameter (QP).
     */
    QP("qp"),

    /**
     * Motion vector.
     */
    MV("mv"),

    DCT_COEFF("dct_coeff"),

    SKIP("skip"),

    START_CODE("startcode"),

    PTS("pts"),

    ER("er"),

    /**
     * Memory management control operations (H.264).
     */
    MMCO("mmco"),

    BUGS("bugs"),

    /**
     * Visualize quantization parameter (QP), lower QP are tinted greener.
     */
    VIS_QP("vis_qp"),

    /**
     * Visualize block types.
     */
    VIS_MB_TYPE("vis_mb_type"),

    /**
     * Picture buffer allocations.
     */
    BUFFERS("buffers"),

    /**
     * Threading operations.
     */
    THREAD_OPS("thread_ops");


    private final String name;


    private AVDebugInfoType(final String name) {
        this.name = name;
    }


    public String getName() {
        return name;
    }

}
