package com.avconv4java.model;

/**
 * @author Vladislav Bauer
 */

public enum AVStreamType {

    AUDIO("a"),

    VIDEO("v"),

    SUBTITLE("s");


    private final String name;


    private AVStreamType(final String name) {
        this.name = name;
    }


    public String getName() {
        return name;
    }

}
