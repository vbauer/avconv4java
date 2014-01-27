package com.avconv4java.model;

/**
 * @author Vladislav Bauer
 */

public enum  AVTargetFileType {

    VCD(Constants.TYPE_VCD),

    SVCD(Constants.TYPE_SVCD),

    DVD(Constants.TYPE_DVD),

    DV(Constants.TYPE_DV),

    DV50(Constants.TYPE_DV50);


    private final String name;


    private AVTargetFileType(final String name) {
        this.name = name;
    }


    public String getName() {
        return name;
    }


    /**
     * @author Vladislav Bauer
     */

    public static final class Constants {

        private Constants() {
            throw new UnsupportedOperationException();
        }


        public static final String TYPE_VCD = "vcd";
        public static final String TYPE_SVCD = "svcd";
        public static final String TYPE_DVD = "dvd";
        public static final String TYPE_DV = "dv";
        public static final String TYPE_DV50 = "dv50";

        public static final String PREFIX_PAL = "pal-";
        public static final String PREFIX_NTSC = "ntsc-";
        public static final String PREFIX_FILM = "film-";

    }

}
