package com.github.vbauer.avconv4java.type;

import com.github.vbauer.avconv4java.util.AVUtils;

/**
 * @author Vladislav Bauer
 */

public enum AVStreamType implements NamedType {

    AUDIO(Constants.AUDIO),

    VIDEO(Constants.VIDEO),

    SUBTITLE(Constants.SUBTITLE);


    private final String name;


    AVStreamType(final String name) {
        this.name = name;
    }


    @Override
    public String getName() {
        return name;
    }


    public static AVStreamType findByName(final String name) {
        return AVUtils.findByName(AVStreamType.class, name);
    }


    /**
     * @author Vladislav Bauer
     */

    public static final class Constants {

        public static final String AUDIO = "a";
        public static final String VIDEO = "v";
        public static final String SUBTITLE = "s";


        private Constants() {
            throw new UnsupportedOperationException();
        }

    }

}
