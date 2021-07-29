package com.tistory.devs0n.user.ui.dto

import com.tistory.devs0n.user.client.OrderResponse
import com.tistory.devs0n.user.domain.User

data class UserResponse(
    val email: String,
    val name: String,
    val userId: String,
    val orders: List<OrderResponse>
) {
    companion object {
        fun of(user: User, orders: List<OrderResponse>) = UserResponse(user.email, user.name, user.userId, orders)
    }
}
