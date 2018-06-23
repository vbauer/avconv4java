package com.github.vbauer.avconv4java.type;

import com.github.vbauer.avconv4java.util.AVUtils;

/**
 * @author Vladislav Bauer
 */

public enum AVTargetFileType implements NamedType {

    VCD(Constants.VCD),

    SVCD(Constants.SVCD),

    DVD(Constants.DVD),

    DV(Constants.DV),

    DV50(Constants.DV50);


    private final String name;


    AVTargetFileType(final String name) {
        this.name = name;
    }


    @Override
    public String getName() {
        return name;
    }


    public static AVTargetFileType findByName(final String name) {
        return AVUtils.findByName(AVTargetFileType.class, name);
    }


    /**
     * @author Vladislav Bauer
     */

    public static final class Constants {

        public static final String VCD = "vcd";
        public static final String SVCD = "svcd";
        public static final String DVD = "dvd";
        public static final String DV = "dv";
        public static final String DV50 = "dv50";

        public static final String PREFIX_PAL = "pal-";
        public static final String PREFIX_NTSC = "ntsc-";
        public static final String PREFIX_FILM = "film-";


        private Constants() {
            throw new UnsupportedOperationException();
        }

    }

}
