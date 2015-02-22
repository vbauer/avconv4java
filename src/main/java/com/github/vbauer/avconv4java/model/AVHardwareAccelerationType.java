package com.github.vbauer.avconv4java.model;

/**
 * @author Vladislav Bauer
 */

public enum AVHardwareAccelerationType {

    /**
     * Do not use any hardware acceleration (the default).
     */
    NONE(Constants.NONE),

    /**
     * Automatically select the hardware acceleration method.
     */
    AUTO(Constants.AUTO),

    /**
     * Use VDPAU (Video Decode and Presentation API for Unix) hardware acceleration.
     */
    VDPAU(Constants.VDPAU);


    private final String name;


    private AVHardwareAccelerationType(final String name) {
        this.name = name;
    }


    public String getName() {
        return name;
    }


    public static AVHardwareAccelerationType findByName(final String name) {
        for (final AVHardwareAccelerationType type : values()) {
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

        public static final String NONE = "none";
        public static final String AUTO = "auto";
        public static final String VDPAU = "vdpau";


        private Constants() {
            throw new UnsupportedOperationException();
        }

    }

}
