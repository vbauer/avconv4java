package com.github.vbauer.avconv4java.model;

/**
 * @author Vladislav Bauer
 */

public enum AVStreamType {

    AUDIO(Constants.AUDIO),

    VIDEO(Constants.VIDEO),

    SUBTITLE(Constants.SUBTITLE);


    private final String name;


    private AVStreamType(final String name) {
        this.name = name;
    }


    public String getName() {
        return name;
    }


    public static AVStreamType findByName(final String name) {
        for (final AVStreamType type : values()) {
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

        public static final String AUDIO = "a";
        public static final String VIDEO = "v";
        public static final String SUBTITLE = "s";


        private Constants() {
            throw new UnsupportedOperationException();
        }

    }

}
