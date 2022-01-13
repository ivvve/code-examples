package com.tistory.devs0n.point.model

import com.tistory.devs0n.point.common.AutoIdBaseEntity
import java.util.*

class PointHistory : AutoIdBaseEntity() {
//    val status: PointStatus
//    val reason: String
//    val expiresAt: String
}

fun main() {
//    PointHistory().id
    repeat(100) {
        println(UUID.randomUUID().toString())
    }
}
