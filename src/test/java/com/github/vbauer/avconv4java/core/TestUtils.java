package com.github.vbauer.avconv4java.core;

import org.testng.Assert;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Modifier;

/**
 * @author Vladislav Bauer
 */

public final class TestUtils {

    private TestUtils() {
        throw new UnsupportedOperationException();
    }


    public static void checkUtilClassConstructor(Class<?> utilsClass) throws Throwable {
        final Constructor<?>[] constructors = utilsClass.getDeclaredConstructors();
        Assert.assertEquals(constructors.length, 1);

        final Constructor<?> constructor = constructors[0];
        final int modifiers = constructor.getModifiers();
        Assert.assertTrue(Modifier.isPrivate(modifiers));

        constructor.setAccessible(true);
        try {
            Assert.fail(constructor.newInstance().toString());
        } catch (final InvocationTargetException ex) {
            throw ex.getCause();
        }
    }

}
