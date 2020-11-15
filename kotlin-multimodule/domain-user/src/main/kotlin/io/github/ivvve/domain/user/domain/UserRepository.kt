package io.github.ivvve.domain.user.domain

interface UserRepository {
    fun save(user: User): User
    fun findById(userId: UserID): User?
}