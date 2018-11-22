package com.xurxodev.multiplatform.library

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.promise

actual fun <T> executeCall(block: suspend () -> T): dynamic {
    return GlobalScope.promise {
       block()
    }
}