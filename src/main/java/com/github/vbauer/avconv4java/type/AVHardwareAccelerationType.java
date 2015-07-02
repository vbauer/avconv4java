package com.github.vbauer.avconv4java.type;

import com.github.vbauer.avconv4java.util.AVUtils;

/**
 * @author Vladislav Bauer
 */

public enum AVHardwareAccelerationType implements NamedType {

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


    AVHardwareAccelerationType(final String name) {
        this.name = name;
    }


    @Override
    public String getName() {
        return name;
    }


    public static AVHardwareAccelerationType findByName(final String name) {
        return AVUtils.findByName(AVHardwareAccelerationType.class, name);
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
