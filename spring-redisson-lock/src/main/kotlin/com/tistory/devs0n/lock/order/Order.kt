package com.tistory.devs0n.lock.order

import java.time.Instant

class Order {
    var id: Long? = null
        private set

    val userId: Long

    val orderedAt: Instant

    var createdAt: Instant = Instant.now()
        private set

    var updatedAt: Instant = Instant.now()
        private set

    constructor(userId: Long) {
        this.userId = userId
        this.orderedAt = Instant.now()
    }
}
