package com.avconv4java.model;

/**
 * @author Vladislav Bauer
 */

public enum AVVideoSizeType {

    SQCIF("sqcif", 128, 96),

    QCIF("qcif", 176, 144),

    CIF("cif", 352, 288),

    CIF4("4cif", 704, 576),

    CIF16("16cif", 1408, 1152),

    QQVGA("qqvga", 160, 120),

    QVGA("qvga", 320, 240),

    VGA("vga", 640, 480),

    SVGA("svga", 800, 600),

    XGA("xga", 1024, 768),

    UXGA("uxga", 1600, 1200),

    QXGA("qxga", 2048, 1536),

    SXGA("sxga", 1280, 1024),

    QSXGA("qsxga", 2560, 2048),

    HSXGA("hsxga", 5120, 4096),

    WVGA("wvga", 852, 480),

    WXGA("wxga", 1366, 768),

    WSXGA("wsxga", 1600, 1024),

    WUXGA("wuxga", 1920,1200),

    WOXGA("woxga", 2560, 1600),

    WQSXGA("wqsxga", 3200, 2048),

    WQUXGA("wquxga", 3840, 2400),

    WHSXGA("whsxga", 6400, 4096),

    WHUXGA("whuxga", 7680, 4800),

    CGA("cga", 320, 200),

    EGA("ega", 640, 350),

    HD480("hd480", 852, 480),

    HD720("hd720", 1280, 720),

    HD1080("hd1080", 1920, 1080);


    private final String name;
    private final int width;
    private final int height;


    private AVVideoSizeType(final String name, final int width, final int height) {
        this.name = name;
        this.width = width;
        this.height = height;
    }


    public String getName() {
        return name;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

}
