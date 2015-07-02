package com.github.vbauer.avconv4java.type;

/**
 * @author Vladislav Bauer
 */

public enum AVVideoSizeType implements NamedType {

    SQCIF(Constants.SQCIF, 128, 96),

    QCIF(Constants.QCIF, 176, 144),

    CIF(Constants.CIF, 352, 288),

    CIF4(Constants.CIF4, 704, 576),

    CIF16(Constants.CIF16, 1408, 1152),

    QQVGA(Constants.QQVGA, 160, 120),

    QVGA(Constants.QVGA, 320, 240),

    VGA(Constants.VGA, 640, 480),

    SVGA(Constants.SVGA, 800, 600),

    XGA(Constants.XGA, 1024, 768),

    UXGA(Constants.UXGA, 1600, 1200),

    QXGA(Constants.QXGA, 2048, 1536),

    SXGA(Constants.SXGA, 1280, 1024),

    QSXGA(Constants.QSXGA, 2560, 2048),

    HSXGA(Constants.HSXGA, 5120, 4096),

    WVGA(Constants.WVGA, 852, 480),

    WXGA(Constants.WXGA, 1366, 768),

    WSXGA(Constants.WSXGA, 1600, 1024),

    WUXGA(Constants.WUXGA, 1920, 1200),

    WOXGA(Constants.WOXGA, 2560, 1600),

    WQSXGA(Constants.WQSXGA, 3200, 2048),

    WQUXGA(Constants.WQUXGA, 3840, 2400),

    WHSXGA(Constants.WHSXGA, 6400, 4096),

    WHUXGA(Constants.WHUXGA, 7680, 4800),

    CGA(Constants.CGA, 320, 200),

    EGA(Constants.EGA, 640, 350),

    HD480(Constants.HD480, 852, 480),

    HD720(Constants.HD720, 1280, 720),

    HD1080(Constants.HD1080, 1920, 1080);


    private final String name;
    private final int width;
    private final int height;


    AVVideoSizeType(final String name, final int width, final int height) {
        this.name = name;
        this.width = width;
        this.height = height;
    }


    @Override
    public String getName() {
        return name;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }


    public static AVVideoSizeType findByName(final String name) {
        for (final AVVideoSizeType type : values()) {
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

        public static final String SQCIF = "sqcif";
        public static final String QCIF = "qcif";
        public static final String CIF = "cif";
        public static final String CIF4 = "4cif";
        public static final String CIF16 = "16cif";
        public static final String QQVGA = "qqvga";
        public static final String QVGA = "qvga";
        public static final String VGA = "vga";
        public static final String SVGA = "svga";
        public static final String XGA = "xga";
        public static final String UXGA = "uxga";
        public static final String QXGA = "qxga";
        public static final String SXGA = "sxga";
        public static final String QSXGA = "qsxga";
        public static final String HSXGA = "hsxga";
        public static final String WVGA = "wvga";
        public static final String WXGA = "wxga";
        public static final String WSXGA = "wsxga";
        public static final String WUXGA = "wuxga";
        public static final String WOXGA = "woxga";
        public static final String WQSXGA = "wqsxga";
        public static final String WQUXGA = "wquxga";
        public static final String WHSXGA = "whsxga";
        public static final String WHUXGA = "whuxga";
        public static final String CGA = "cga";
        public static final String EGA = "ega";
        public static final String HD480 = "hd480";
        public static final String HD720 = "hd720";
        public static final String HD1080 = "hd1080";


        private Constants() {
            throw new UnsupportedOperationException();
        }

    }

}
