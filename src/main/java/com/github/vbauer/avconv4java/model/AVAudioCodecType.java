package com.github.vbauer.avconv4java.model;

/**
 * @author Vladislav Bauer
 */

public enum AVAudioCodecType {

    VORBIS(Constants.VORBIS),

    /**
     * May be used only with -strict experimental.
     * Not so stable yet and overall quality is very bad, but bundled with avconv
     */
    AAC(Constants.AAC),

    /**
     * The best aac encoder so far, but separate lib.
     */
    FDK_AAC(Constants.FDK_AAC),

    /**
     * Not bad encoder, bundled with daily windows builds.
     */
    VISUAL_ON_AAC(Constants.VISUAL_ON_ACC);


    private final String name;


    private AVAudioCodecType(final String name) {
        this.name = name;
    }


    public String getName() {
        return name;
    }


    public static AVAudioCodecType findByName(final String name) {
        for (final AVAudioCodecType type : values()) {
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

        public static final String VORBIS = "libvorbis";
        public static final String AAC = "aac";
        public static final String FDK_AAC = "libfdk_aac";
        public static final String VISUAL_ON_ACC = "libvo_aacenc";


        private Constants() {
            throw new UnsupportedOperationException();
        }

    }

}
