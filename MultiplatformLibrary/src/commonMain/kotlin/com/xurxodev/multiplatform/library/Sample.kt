package com.xurxodev.multiplatform.library

expect class Sample() {
    fun checkMe(): Int
}

expect object Platform {
    val name: String
}

fun multiplatformHello(): String = "Hello from ${Platform.name}"