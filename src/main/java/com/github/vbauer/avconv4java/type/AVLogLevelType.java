package com.github.vbauer.avconv4java.type;

import com.github.vbauer.avconv4java.util.AVUtils;

/**
 * @author Vladislav Bauer
 */

public enum AVLogLevelType implements NamedType {

    QUIET(Constants.QUIET),

    PANIC(Constants.PANIC),

    FATAL(Constants.FATAL),

    ERROR(Constants.ERROR),

    WARNING(Constants.WARNING),

    INFO(Constants.INFO),

    VERBOSE(Constants.VERBOSE),

    DEBUG(Constants.DEBUG);


    private final String name;


    AVLogLevelType(final String name) {
        this.name = name;
    }


    @Override
    public String getName() {
        return name;
    }


    public static AVLogLevelType findByName(final String name) {
        return AVUtils.findByName(AVLogLevelType.class, name);
    }


    /**
     * @author Vladislav Bauer
     */

    public static final class Constants {

        public static final String QUIET = "quiet";
        public static final String PANIC = "panic";
        public static final String FATAL = "fatal";
        public static final String ERROR = "error";
        public static final String WARNING = "warning";
        public static final String INFO = "info";
        public static final String VERBOSE = "verbose";
        public static final String DEBUG = "debug";


        private Constants() {
            throw new UnsupportedOperationException();
        }

    }

}
