package com.avconv4java.model;

/**
 * @author Vladislav Bauer
 */

public enum AVAudioCodecType {

    VORBIS("libvorbis"),

    /**
     * May be used only with -strict experimental.
     * Not so stable yet and overall quality is very bad, but bundled with avconv
     */
    AAC("aac"),
    /**
     * The best aac encoder so far, but separate lib
     */
    FDK_AAC("libfdk_aac"),
    /**
     * Not bad encoder, bundled with daily windows builds
     */
    VISUAL_ON_AAC("libvo_aacenc");


    private final String name;


    private AVAudioCodecType(final String name) {
        this.name = name;
    }


    public String getName() {
        return name;
    }

}
