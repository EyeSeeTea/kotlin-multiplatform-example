package com.xurxodev.multiplatform.library

actual class Sample {
    actual fun checkMe() = 42
}

actual object Platform {
    actual val name: String = "Android"
}