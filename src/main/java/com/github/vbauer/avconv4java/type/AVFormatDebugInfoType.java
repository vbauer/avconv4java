package com.github.vbauer.avconv4java.type;

import com.github.vbauer.avconv4java.util.AVUtils;

/**
 * @author Vladislav Bauer
 */

public enum AVFormatDebugInfoType implements NamedType {

    TS(Constants.TS);


    private final String name;


    AVFormatDebugInfoType(final String name) {
        this.name = name;
    }


    @Override
    public String getName() {
        return name;
    }


    public static AVFormatDebugInfoType findByName(final String name) {
        return AVUtils.findByName(AVFormatDebugInfoType.class, name);
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
