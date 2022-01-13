package com.tistory.devs0n.point.common

import java.time.LocalDateTime
import java.util.*

abstract class BaseEntity(
    val id: UUID
) {
    // to prevent being nullable type, specify type
    val createdAt: LocalDateTime = LocalDateTime.now()

    var updatedAt: LocalDateTime = LocalDateTime.now()
        protected set

    fun update() {
        this.updatedAt = LocalDateTime.now()
    }
}
