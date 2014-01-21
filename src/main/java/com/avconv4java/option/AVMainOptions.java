package com.avconv4java.option;

import com.avconv4java.core.AVGenericOptions;

/**
 * @author Vladislav Bauer
 */

public class AVMainOptions extends AVGenericOptions {

    public static AVMainOptions create() {
        return new AVMainOptions();
    }


    @Override
    public AVMainOptions flags(final Object... flags) {
        return (AVMainOptions) super.flags(flags);
    }

    @Override
    public AVMainOptions builders(final AVGenericOptions... builders) {
        return (AVMainOptions) super.builders(builders);
    }


    /**
     * ‘-y (global)’
     * Overwrite output files without asking.
     */
    public AVMainOptions overwriteOutput() {
        return flags("-y");
    }

    public AVMainOptions seek(final Double seek) {
        return seek == null ? this : flags("-ss", String.format("%.2f", seek));
    }

}
