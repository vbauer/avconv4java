package com.avconv4java.model;

/**
 * Type shows how strictly to follow the standards.
 *
 * @author Vladislav Bauer
 */

public enum AVStrictType {

    /**
     * Strictly conform to a older more strict version of the spec or reference software.
     */
    VERY("very"),

    /**
     * Strictly conform to all the things in the spec no matter what the consequences.
     */
    STRICT("strict"),

    /**
     * Allow unofficial extensions.
     */
    NORMAL("normal"),

    /**
     * Allow unofficial extensions.
     */
    UNOFFICIAL("unofficial"),

    /**
     * Allow non-standardized experimental things.
     */
    EXPERIMENTAL("experimental");


    private final String name;


    private AVStrictType(final String name) {
        this.name = name;
    }


    public String getName() {
        return name;
    }


    public static AVStrictType findByName(final String name) {
        for (final AVStrictType type : values()) {
            if (type.getName().equalsIgnoreCase(name)) {
                return type;
            }
        }
        return null;
    }

}
