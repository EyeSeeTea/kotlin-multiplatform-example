package com.xurxodev.multiplatform.library

import kotlin.test.Test
import kotlin.test.assertTrue

class SampleTestsJS {
    @Test
    fun testHello() {
        assertTrue("JS" in multiplatformHello())
    }
}