package com.xurxodev.multiplatform.library

import kotlin.test.Test
import kotlin.test.assertTrue

class SampleTestsNative {
    @Test
    fun testHello() {
        assertTrue("Native" in multiplatformHello())
    }
}