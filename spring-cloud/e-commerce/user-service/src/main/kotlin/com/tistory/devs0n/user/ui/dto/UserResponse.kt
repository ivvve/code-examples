package com.tistory.devs0n.user.ui.dto

import com.tistory.devs0n.user.domain.User

data class UserResponse(
    val email: String,
    val name: String,
    val userId: String
) {
    companion object {
        fun of(user: User) = UserResponse(user.email, user.name, user.userId)
    }
}
