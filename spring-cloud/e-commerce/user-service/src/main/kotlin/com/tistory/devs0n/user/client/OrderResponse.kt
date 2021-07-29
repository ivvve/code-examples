package com.tistory.devs0n.user.client

data class OrderResponse(
    val orderId: String,
    val userId: String,
    val productId: String,
    val quantity: Int,
    val unitPrice: Long,
    val totalPrice: Long,
)
