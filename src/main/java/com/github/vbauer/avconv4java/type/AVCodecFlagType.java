package com.github.vbauer.avconv4java.type;

import com.github.vbauer.avconv4java.util.AVUtils;

/**
 * @author Vladislav Bauer
 */

public enum AVCodecFlagType implements NamedType {

    /**
     * Allow decoders to produce unaligned output.
     */
    UNALIGNED(Constants.UNALIGNED),

    /**
     * Use four motion vectors per macroblock (MPEG-4).
     */
    MV4(Constants.MV4),

    /**
     * Use 1/4-pel motion compensation.
     */
    QPEL(Constants.QPEL),

    /**
     * Use loop filter.
     */
    LOOP(Constants.LOOP),

    /**
     * Use fixed qscale.
     */
    QSCALE(Constants.QSCALE),

    /**
     * Use gmc.
     */
    GMC(Constants.GMC),

    /**
     * Always try a mb with mv="0,0".
     */
    MV0(Constants.MV0),

    /**
     * Use internal 2-pass ratecontrol in first pass mode.
     */
    INPUT_PRESERVED(Constants.INPUT_PRESERVED),

    PASS1(Constants.PASS1),

    /**
     * Use internal 2-pass ratecontrol in second pass mode.
     */
    PASS2(Constants.PASS2),

    /**
     * Only decode/encode grayscale.
     */
    GRAY(Constants.GRAY),

    /**
     * Do not draw edges.
     */
    EMU_EDGE(Constants.EMU_EDGE),

    /**
     * Error[?] variables will be set during encoding.
     */
    PSNR(Constants.PSNR),

    /**
     * Normalize adaptive quantization.
     */
    TRUNCATED(Constants.TRUNCATED),

    NAQ(Constants.NAQ),

    /**
     * Use interlaced DCT.
     */
    ILDCT(Constants.ILDCT),

    /**
     * Force low delay.
     */
    LOW_DELAY(Constants.LOW_DELAY),

    /**
     * Place global headers in extradata instead of every keyframe.
     */
    GLOBAL_HEADER(Constants.GLOBAL_HEADER),

    /**
     * Use only bitexact functions (except (I)DCT).
     */
    BITEXACT(Constants.BITEXACT),

    /**
     * H.263 advanced intra coding / MPEG-4 AC prediction.
     */
    AIC(Constants.AIC),

    /**
     * Interlaced motion estimation.
     */
    ILME(Constants.ILME),

    /**
     * Closed GOP.
     */
    CGOP(Constants.CGOP),

    /**
     * Output even potentially corrupted frames.
     */
    OUTPUT_CORRUPT(Constants.OUTPUT_CORRUPT);


    private final String name;


    AVCodecFlagType(final String name) {
        this.name = name;
    }


    @Override
    public String getName() {
        return name;
    }


    public static AVCodecFlagType findByName(final String name) {
        return AVUtils.findByName(AVCodecFlagType.class, name);
    }


    /**
     * @author Vladislav Bauer
     */

    public static final class Constants {

        public static final String UNALIGNED = "unaligned";
        public static final String MV4 = "mv4";
        public static final String QPEL = "qpel";
        public static final String LOOP = "loop";
        public static final String QSCALE = "qscale";
        public static final String GMC = "gmc";
        public static final String MV0 = "mv0";
        public static final String INPUT_PRESERVED = "input_preserved";
        public static final String PASS1 = "pass1";
        public static final String PASS2 = "pass2";
        public static final String GRAY = "gray";
        public static final String EMU_EDGE = "emu_edge";
        public static final String PSNR = "psnr";
        public static final String TRUNCATED = "truncated";
        public static final String NAQ = "naq";
        public static final String ILDCT = "ildct";
        public static final String LOW_DELAY = "low_delay";
        public static final String GLOBAL_HEADER = "global_header";
        public static final String BITEXACT = "bitexact";
        public static final String AIC = "aic";
        public static final String ILME = "ilme";
        public static final String CGOP = "cgop";
        public static final String OUTPUT_CORRUPT = "output_corrupt";


        private Constants() {
            throw new UnsupportedOperationException();
        }

    }

}
