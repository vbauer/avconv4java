package com.github.vbauer.avconv4java.common;

import com.pushtorefresh.private_constructor_checker.PrivateConstructorChecker;

/**
 * @author Vladislav Bauer
 */

public final class TestUtils {

    private TestUtils() {
        throw new UnsupportedOperationException();
    }


    public static void checkUtilClassConstructor(final Class<?> utilsClass) {
        PrivateConstructorChecker.forClass(utilsClass)
            .expectedTypeOfException(UnsupportedOperationException.class)
            .check();
    }

}
