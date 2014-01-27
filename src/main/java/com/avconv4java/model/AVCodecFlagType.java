package com.avconv4java.model;

/**
 * @author Vladislav Bauer
 */

public enum AVCodecFlagType {

    /**
     * Allow decoders to produce unaligned output.
     */
    UNALIGNED("unaligned"),

    /**
     * Use four motion vectors per macroblock (MPEG-4).
     */
    MV4("mv4"),

    /**
     * Use 1/4-pel motion compensation.
     */
    QPEL("qpel"),

    /**
     * Use loop filter.
     */
    LOOP("loop"),

    /**
     * Use fixed qscale.
     */
    QSCALE("qscale"),

    /**
     * Use gmc.
     */
    GMC("gmc"),

    /**
     * Always try a mb with mv=<0,0>.
     */
    MV0("mv0"),

    /**
     * Use internal 2-pass ratecontrol in first pass mode.
     */
    INPUT_PRESERVED("input_preserved"),

    PASS1("pass1"),

    /**
     * Use internal 2-pass ratecontrol in second pass mode.
     */
    PASS2("pass2"),

    /**
     * Only decode/encode grayscale.
     */
    GRAY("gray"),

    /**
     * Do not draw edges.
     */
    EMU_EDGE("emu_edge"),

    /**
     * Error[?] variables will be set during encoding.
     */
    PSNR("psnr"),

    /**
     * Normalize adaptive quantization.
     */
    TRUNCATED("truncated"),

    NAQ("naq"),

    /**
     * Use interlaced DCT.
     */
    ILDCT("ildct"),

    LOW_DELAY("low_delay"),

    FORCE_LOW_DELAY("force low delay"),

    /**
     * Place global headers in extradata instead of every keyframe.
     */
    GLOBAL_HEADER("global_header"),

    /**
     * Use only bitexact functions (except (I)DCT).
     */
    BITEXACT("bitexact"),

    /**
     * H.263 advanced intra coding / MPEG-4 AC prediction.
     */
    AIC("aic"),

    /**
     * Interlaced motion estimation.
     */
    ILME("ilme"),

    /**
     * Closed GOP.
     */
    CGOP("cgop"),

    /**
     * Output even potentially corrupted frames.
     */
    OUTPUT_CORRUPT("output_corrupt");


    private final String name;


    private AVCodecFlagType(final String name) {
        this.name = name;
    }


    public String getName() {
        return name;
    }


    public static AVCodecFlagType findByName(final String name) {
        for (final AVCodecFlagType type : values()) {
            if (type.getName().equalsIgnoreCase(name)) {
                return type;
            }
        }
        return null;
    }

}
