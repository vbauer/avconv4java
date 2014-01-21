package com.avconv4java.util;

/**
 * @author Vladislav Bauer
 */

public final class AVTextUtils {

    public static final String SPACE = " ";


    private AVTextUtils() {
        throw new UnsupportedOperationException();
    }


    public static String join(final Iterable<String> arguments) {
        return join(arguments, SPACE);
    }

    public static String join(final Iterable<String> arguments, final String delimiter) {
        final StringBuilder buf = new StringBuilder();
        boolean first = true;

        for (final String arg : arguments) {
            if (arg != null) {
                if (first) {
                    first = false;
                } else {
                    buf.append(delimiter);
                }
                buf.append(arg);
            }
        }
        return buf.toString();
    }

}
