package com.tistory.devs0n.order.ui.dto

import com.tistory.devs0n.order.domain.Order

data class OrderResponse(
    val orderId: String,
    val userId: String,
    val productId: String,
    val quantity: Int,
    val unitPrice: Long,
    val totalPrice: Long,
) {
    companion object {
        fun of(order: Order): OrderResponse {
            return OrderResponse(
                order.orderId,
                order.userId,
                order.productId,
                order.quantity,
                order.unitPrice,
                order.totalPrice
            )
        }
    }
}
