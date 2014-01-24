package com.avconv4java.util;

import java.util.Arrays;

/**
 * @author Vladislav Bauer
 */

public final class AVUtils {

    public static final String SPACE = " ";


    private AVUtils() {
        throw new UnsupportedOperationException();
    }


    public static boolean isEmpty(Object... arguments) {
        return arguments == null || arguments.length == 0;
    }

    public static String join(final String... arguments) {
        return join(isEmpty(arguments) ? null : Arrays.asList(arguments), SPACE);
    }

    public static String join(final Iterable<String> arguments) {
        return join(arguments, SPACE);
    }

    public static String join(final Iterable<String> arguments, final String delimiter) {
        final StringBuilder buf = new StringBuilder();
        if (arguments != null) {
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
        }
        return buf.toString();
    }

}
