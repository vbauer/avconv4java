package com.github.vbauer.avconv4java.model;

/**
 * Type shows how strictly to follow the standards.
 *
 * @author Vladislav Bauer
 */

public enum AVStrictType {

    /**
     * Strictly conform to a older more strict version of the spec or reference software.
     */
    VERY(Constants.VERY),

    /**
     * Strictly conform to all the things in the spec no matter what the consequences.
     */
    STRICT(Constants.STRICT),

    /**
     * Allow unofficial extensions.
     */
    NORMAL(Constants.NORMAL),

    /**
     * Allow unofficial extensions.
     */
    UNOFFICIAL(Constants.UNOFFICIAL),

    /**
     * Allow non-standardized experimental things.
     */
    EXPERIMENTAL(Constants.EXPERIMENTAL);


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


    /**
     * @author Vladislav Bauer
     */

    public static final class Constants {

        public static final String VERY = "very";
        public static final String STRICT = "strict";
        public static final String NORMAL = "normal";
        public static final String UNOFFICIAL = "unofficial";
        public static final String EXPERIMENTAL = "experimental";


        private Constants() {
            throw new UnsupportedOperationException();
        }

    }

}
