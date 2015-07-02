package com.github.vbauer.avconv4java.type;

import com.github.vbauer.avconv4java.util.AVUtils;

/**
 * @author Vladislav Bauer
 */

public enum AVFormatFlagType implements NamedType {

    /**
     * Reduce the latency by flushing out packets immediately.
     */
    FLUSH_PACKETS(Constants.FLUSH_PACKETS),

    /**
     * Ignore index.
     */
    IGNORE_INDEX(Constants.IGNORE_INDEX),

    /**
     * Generate pts.
     */
    GENERATE_PTS(Constants.GENERATE_PTS),

    /**
     * Do not fill in missing values that can be exactly calculated.
     */
    NO_FILL_IN(Constants.NO_FILL_IN),

    /**
     * Disable AVParsers, this needs nofillin too.
     */
    NO_PARSE(Constants.NO_PARSE),

    /**
     * Ignore dts.
     */
    IGNORE_DTS(Constants.IGNORE_DTS),

    /**
     * Discard corrupted frames.
     */
    DISCARD_CORRUPTED(Constants.DISCARD_CORRUPTED),

    /**
     * Reduce the latency introduced by optional buffering.
     */
    NO_BUFFER(Constants.NO_BUFFER);


    private final String name;


    AVFormatFlagType(final String name) {
        this.name = name;
    }


    @Override
    public String getName() {
        return name;
    }


    public static AVFormatFlagType findByName(final String name) {
        return AVUtils.findByName(AVFormatFlagType.class, name);
    }


    /**
     * @author Vladislav Bauer
     */

    public static final class Constants {

        public static final String FLUSH_PACKETS = "flush_packets";
        public static final String IGNORE_INDEX = "ignidx";
        public static final String GENERATE_PTS = "genpts";
        public static final String NO_FILL_IN = "nofillin";
        public static final String NO_PARSE = "noparse";
        public static final String IGNORE_DTS = "igndts";
        public static final String DISCARD_CORRUPTED = "discardcorrupt";
        public static final String NO_BUFFER = "nobuffer";


        private Constants() {
            throw new UnsupportedOperationException();
        }

    }

}
