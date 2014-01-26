package com.avconv4java.model;

/**
 * @author Vladislav Bauer
 */

public enum AVLogLevelType {

    QUIET("quiet"),

    PANIC("panic"),

    FATAL("fatal"),

    ERROR("error"),

    WARNING("warning"),

    INFO("info"),

    VERBOSE("verbose"),

    DEBUG("debug");


    private final String name;


    private AVLogLevelType(final String name) {
        this.name = name;
    }


    public String getName() {
        return name;
    }


}
