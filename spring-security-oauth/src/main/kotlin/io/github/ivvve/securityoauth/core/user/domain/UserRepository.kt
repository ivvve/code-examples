package io.github.ivvve.securityoauth.core.user.domain

interface UserRepository {
    fun save(user: User): User
    fun findByEmail(email: String): User?
}