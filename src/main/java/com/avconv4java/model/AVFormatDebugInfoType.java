package com.avconv4java.model;

/**
 * @author Vladislav Bauer
 */

public enum AVFormatDebugInfoType {

    TS("ts");


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


}
