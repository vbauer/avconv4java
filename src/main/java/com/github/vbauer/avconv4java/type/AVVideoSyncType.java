package com.github.vbauer.avconv4java.type;

import com.github.vbauer.avconv4java.util.AVUtils;

/**
 * @author Vladislav Bauer
 */

public enum AVVideoSyncType implements NamedType {

    /**
     * Each frame is passed with its timestamp from the demuxer to the muxer.
     */
    PASS_THROUGH(Constants.PASS_THROUGH),

    /**
     * Frames will be duplicated and dropped to achieve exactly the requested constant framerate.
     */
    CRF(Constants.CFR),

    /**
     * Frames are passed through with their timestamp or dropped so as to prevent 2 frames from having same timestamp.
     */
    VFR(Constants.VFR),

    /**
     * Chooses between 1 and 2 depending on muxer capabilities. This is the default method.
     */
    AUTO(Constants.AUTO);


    private final String name;


    AVVideoSyncType(final String name) {
        this.name = name;
    }


    @Override
    public String getName() {
        return name;
    }


    public static AVVideoSyncType findByName(final String name) {
        return AVUtils.findByName(AVVideoSyncType.class, name);
    }


    /**
     * @author Vladislav Bauer
     */

    public static final class Constants {

        public static final String PASS_THROUGH = "passthrough";
        public static final String CFR = "cfr";
        public static final String VFR = "vfr";
        public static final String AUTO = "auto";


        private Constants() {
            throw new UnsupportedOperationException();
        }

    }

}
