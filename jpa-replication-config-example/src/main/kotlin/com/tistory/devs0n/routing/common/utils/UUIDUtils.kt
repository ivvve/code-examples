package com.tistory.devs0n.routing.common.utils

import java.util.*

fun isUUID(value: String): Boolean {
    return try {
        UUID.fromString(value)
        true
    } catch (e: IllegalArgumentException) {
        false
    }
}

fun isNotUUID(value: String): Boolean = !isUUID(value)

