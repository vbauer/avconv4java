package com.github.vbauer.avconv4java.common

import com.pushtorefresh.private_constructor_checker.PrivateConstructorChecker

/**
 * @author Vladislav Bauer
 */

class TestUtils private constructor() {

    companion object {
        fun checkUtilClassConstructor(utilsClass: Class<*>) {
            PrivateConstructorChecker.forClass(utilsClass)
                    .expectedTypeOfException(UnsupportedOperationException::class.java)
                    .check()
        }
    }

}
