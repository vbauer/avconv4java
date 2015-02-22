package com.github.vbauer.avconv4java.model;

/**
 * @author Vladislav Bauer
 */

public enum AVFormatDebugInfoType {

    TS(Constants.TS);


    private final String name;


    private AVFormatDebugInfoType(final String name) {
        this.name = name;
    }


    public String getName() {
        return name;
    }


    public static AVFormatDebugInfoType findByName(final String name) {
        for (final AVFormatDebugInfoType type : values()) {
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

        public static final String TS = "ts";


        private Constants() {
            throw new UnsupportedOperationException();
        }

    }

}
