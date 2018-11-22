package com.xurxodev.multiplatform.library

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.runBlocking

actual fun <T> executeCall(block: suspend () -> T): T {
    return runBlocking { block() }
}