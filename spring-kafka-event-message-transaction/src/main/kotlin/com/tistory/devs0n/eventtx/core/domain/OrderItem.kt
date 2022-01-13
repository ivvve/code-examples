package com.tistory.devs0n.eventtx.core.domain

import javax.persistence.Column
import javax.persistence.Embeddable

@Embeddable
data class OrderItem(
    @Column
    val productId: String,
    val quantity: Int,
)
