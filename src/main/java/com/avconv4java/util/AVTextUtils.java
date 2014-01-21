package com.avconv4java.util;

import java.util.List;

/**
 * @author Vladislav Bauer
 */

public final class AVTextUtils {

    public static final String SPACE = " ";


    private AVTextUtils() {
        throw new UnsupportedOperationException();
    }


    public static String join(final List<String> arguments) {
        return join(arguments, SPACE);
    }

    public static String join(final List<String> arguments, final String delimiter) {
        final StringBuilder buf = new StringBuilder();
        for (final String arg : arguments) {
            buf.append(arg).append(delimiter);

        }
        return buf.toString();
    }

}
