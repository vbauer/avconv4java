package com.github.vbauer.avconv4java.util;

import com.github.vbauer.avconv4java.type.NamedType;

import java.io.*;
import java.nio.charset.Charset;
import java.util.Arrays;
import java.util.Collection;
import java.util.Map;

/**
 * Generic utils.
 *
 * @author Vladislav Bauer
 */

public final class AVUtils {

    public static final String SYSTEM_PROPERTY_OS_NAME = "os.name";
    public static final String SYSTEM_PROPERTY_LINE_SEPARATOR = "line.separator";

    public static final String SPACE = " ";
    public static final String EMPTY = "";

    private static final String OS = getSystemProperty(SYSTEM_PROPERTY_OS_NAME).toLowerCase();
    private static final String LINE_SEPARATOR = getSystemProperty(SYSTEM_PROPERTY_LINE_SEPARATOR);


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

    public static boolean isEmpty(final Collection list) {
        return list == null || list.isEmpty();
    }

    public static boolean isBlank(final Object text) {
        return trimToNull(text) == null;
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
        return join(isEmpty((Object[]) arguments) ? null : Arrays.asList(arguments), SPACE);
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

    public static String getSystemProperty(final String key) {
        final String envProperty = System.getenv(key);
        return envProperty == null ? System.getProperty(key) : envProperty;
    }

    public static <T> T defaultValue(final T value, final T defaultValue) {
        return value == null ? defaultValue : value;
    }

    public static String readFully(final InputStream inputStream) {
        BufferedReader reader = null;
        try {
            final StringBuilder result = new StringBuilder();
            reader = new BufferedReader(new InputStreamReader(inputStream, Charset.defaultCharset()));
            String line;

            while ((line = reader.readLine()) != null) {
                result.append(line);
                result.append(LINE_SEPARATOR);
            }
            return result.toString();
        } catch (final Throwable ex) {
            return null;
        } finally {
            closeQuietly(reader);
        }
    }

    public static boolean closeQuietly(final Reader reader) {
        try {
            reader.close();
            return true;
        } catch (final Throwable ex) {
            return false;
        }
    }

    public static <T extends Enum & NamedType> T findByName(
        final Class<T> enumClass, final String name
    ) {
        final T[] values = enumClass.getEnumConstants();
        for (final T value : values) {
            final String valueName = value.getName();
            if (valueName.equalsIgnoreCase(name)) {
                return value;
            }
        }
        return null;
    }

}
