package com.github.vbauer.avconv4java.model;

/**
 * @author Vladislav Bauer
 */

public enum AVFileFormatType {

    /**
     * Image file muxer.
     */
    IMAGE(Constants.IMAGE),

    /**
     * CRC (Cyclic Redundancy Check) testing format.
     */
    CRC(Constants.CRC),

    /**
     * Per-frame CRC (Cyclic Redundancy Check) testing format.
     */
    FRAME_CRC(Constants.FRAME_CRC),

    /**
     * Apple HTTP Live Streaming muxer that segments MPEG-TS according to the HTTP Live Streaming specification.
     */
    HLS(Constants.HLS),

    /**
     * MPEG transport stream muxer.
     */
    MPEG_TRANSPORT(Constants.MPEG_TRANSPORT),

    /**
     * Null muxer.
     */
    NULL(Constants.NULL),

    /**
     * Matroska container muxer.
     */
    MATROSKA(Constants.MATROSKA),

    /**
     * Basic stream segmenter.
     */
    SEGMENT(Constants.SEGMENT),

    /**
     * MP3 container muxer.
     */
    MP3(Constants.MP3),

    /**
     * Ogg container muxer.
     */
    OGG(Constants.OGG);


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


    /**
     * @author Vladislav Bauer
     */

    public static final class Constants {

        public static final String IMAGE = "image2";
        public static final String CRC = "crc";
        public static final String FRAME_CRC = "framecrc";
        public static final String HLS = "hls";
        public static final String MPEG_TRANSPORT = "mpegts";
        public static final String NULL = "null";
        public static final String MATROSKA = "matroska";
        public static final String SEGMENT = "segment";
        public static final String MP3 = "mp3";
        public static final String OGG = "ogg";


        private Constants() {
            throw new UnsupportedOperationException();
        }

    }

}
