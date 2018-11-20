package com.xurxodev.multiplatform.library

import kotlin.test.Test
import kotlin.test.assertTrue

class SampleTestsAndroid {
    @Test
    fun testHello() {
        assertTrue("Android" in Hello().multiplatformHello())
    }
}