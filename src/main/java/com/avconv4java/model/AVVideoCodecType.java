package com.avconv4java.model;

/**
 * @author Vladislav Bauer
 */

public enum AVVideoCodecType {

    H264("libx264"),

    THEORA("libtheora");


    private final String name;


    private AVVideoCodecType(final String name) {
        this.name = name;
    }


    public String getName() {
        return name;
    }

}
