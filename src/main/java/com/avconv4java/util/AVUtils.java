package com.avconv4java.util;

import java.util.Arrays;
import java.util.Map;

/**
 * @author Vladislav Bauer
 */

public final class AVUtils {

    public static final String OS = System.getProperty("os.name").toLowerCase();

    public static final String SPACE = " ";
    public static final String EMPTY = "";


    private AVUtils() {
        throw new UnsupportedOperationException();
    }


    public static boolean hasNull(final Object... arguments) {
        if (!isEmpty(arguments)) {
            for (final Object argument : arguments) {
                if (argument == null) {
                    return true;
                }
            }
            return false;
        }
        return true;
    }

    public static boolean isEmpty(final Object... arguments) {
        return arguments == null || arguments.length == 0;
    }

    public static boolean isEmpty(final Map map) {
        return map == null || map.isEmpty();
    }


    public static String trimToNull(final Object text) {
        if (text != null) {
            final String trim = text.toString().trim();
            return trim.length() > 0 ? trim : null;
        }
        return null;
    }

    public static String trimToEmpty(final Object text) {
        return text != null ? text.toString().trim() : EMPTY;
    }

    public static String join(final String... arguments) {
        return join(isEmpty(arguments) ? null : Arrays.asList(arguments), SPACE);
    }

    public static String join(final Iterable<String> arguments) {
        return join(arguments, SPACE);
    }

    public static String join(final Iterable<String> arguments, final String delimiter) {
        final StringBuilder buffer = new StringBuilder();
        if (arguments != null) {
            boolean first = true;
            for (final String arg : arguments) {
                if (arg != null) {
                    if (first) {
                        first = false;
                    } else {
                        buffer.append(delimiter);
                    }
                    buffer.append(arg);
                }
            }
        }
        return trimToNull(buffer);
    }


    public static boolean isWindows() {
        return OS.contains("win");
    }

    public static boolean isMac() {
        return OS.contains("mac");
    }

    public static boolean isUnix() {
        return OS.contains("nix") || OS.contains("nux") || OS.contains("aix");
    }

    public static boolean isSolaris() {
        return OS.contains("sunos");
    }

}
