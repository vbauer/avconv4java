package com.avconv4java.model;

/**
 * @author Vladislav Bauer
 */

public enum AVHardwareAccelerationType {

    /**
     * Do not use any hardware acceleration (the default).
     */
    NONE("none"),

    /**
     * Automatically select the hardware acceleration method.
     */
    AUTO("auto"),

    /**
     * Use VDPAU (Video Decode and Presentation API for Unix) hardware acceleration.
     */
    VDPAU("vdpau");


    private final String name;


    private AVHardwareAccelerationType(final String name) {
        this.name = name;
    }


    public String getName() {
        return name;
    }

}
