package com.avconv4java.model;

/**
 * @author Vladislav Bauer
 */

public enum AVFileFormatType {

    /**
     * Image file muxer.
     */
    IMAGE("image2"),

    /**
     * CRC (Cyclic Redundancy Check) testing format.
     */
    CRC("crc"),

    /**
     * Per-frame CRC (Cyclic Redundancy Check) testing format.
     */
    FRAME_CRC("framecrc"),

    /**
     * Apple HTTP Live Streaming muxer that segments MPEG-TS according to the HTTP Live Streaming specification.
     */
    HLS("hls"),

    /**
     * MPEG transport stream muxer.
     */
    MPEG_TRANSPORT("mpegts"),

    /**
     * Null muxer.
     */
    NULL("null"),

    /**
     * Matroska container muxer.
     */
    MATROSKA("matroska"),

    /**
     * Basic stream segmenter.
     */
    SEGMENT("segment"),

    /**
     * MP3 container muxer.
     */
    MP3("mp3"),

    /**
     * Ogg container muxer.
     */
    OGG("ogg");


    private final String name;


    private AVFileFormatType(final String name) {
        this.name = name;
    }


    public String getName() {
        return name;
    }


    public static AVFileFormatType findByName(final String name) {
        for (final AVFileFormatType type : values()) {
            if (type.getName().equalsIgnoreCase(name)) {
                return type;
            }
        }
        return null;
    }

}
