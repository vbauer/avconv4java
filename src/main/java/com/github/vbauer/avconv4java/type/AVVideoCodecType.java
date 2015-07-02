package com.github.vbauer.avconv4java.type;

import com.github.vbauer.avconv4java.util.AVUtils;

/**
 * @author Vladislav Bauer
 */

public enum AVVideoCodecType implements NamedType {

    H264(Constants.H264),

    THEORA(Constants.THEORA);


    private final String name;


    AVVideoCodecType(final String name) {
        this.name = name;
    }


    @Override
    public String getName() {
        return name;
    }


    public static AVVideoCodecType findByName(final String name) {
        return AVUtils.findByName(AVVideoCodecType.class, name);
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
