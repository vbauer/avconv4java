package com.avconv4java.model;

/**
 * @author Vladislav Bauer
 */

public enum AVFormatFlagType {

    /**
     * Reduce the latency by flushing out packets immediately.
     */
    FLUSH_PACKETS("flush_packets"),

    /**
     * Ignore index.
     */
    IGNORE_INDEX("ignidx"),

    /**
     * Generate pts.
     */
    GENERATE_PTS("genpts"),

    /**
     * Do not fill in missing values that can be exactly calculated.
     */
    NO_FILL_IN("nofillin"),

    /**
     * Disable AVParsers, this needs nofillin too.
     */
    NO_PARSE("noparse"),

    /**
     * Ignore dts.
     */
    IGNORE_DTS("igndts"),

    /**
     * Discard corrupted frames.
     */
    DISCARD_CORRUPTED("discardcorrupt"),

    /**
     * Reduce the latency introduced by optional buffering.
     */
    NO_BUFFER("nobuffer");


    private final String name;


    private AVFormatFlagType(final String name) {
        this.name = name;
    }


    public String getName() {
        return name;
    }


    public static AVFormatFlagType findByName(final String name) {
        for (final AVFormatFlagType type : values()) {
            if (type.getName().equalsIgnoreCase(name)) {
                return type;
            }
        }
        return null;
    }

}
