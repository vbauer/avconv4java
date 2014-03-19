package com.avconv4java.model;

/**
 * @author Vladislav Bauer
 */

public enum AVVideoCodecType {

    H264(Constants.H264),

    THEORA(Constants.THEORA);


    private final String name;


    private AVVideoCodecType(final String name) {
        this.name = name;
    }


    public String getName() {
        return name;
    }


    public static AVVideoCodecType findByName(final String name) {
        for (final AVVideoCodecType type : values()) {
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

        public static final String H264 = "libx264";
        public static final String THEORA = "libtheora";


        private Constants() {
            throw new UnsupportedOperationException();
        }

    }

}
