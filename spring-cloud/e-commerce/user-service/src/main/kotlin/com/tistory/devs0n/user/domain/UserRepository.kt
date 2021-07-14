package com.tistory.devs0n.user.domain

import org.springframework.data.repository.CrudRepository

interface UserRepository : CrudRepository<User, Long> {
    fun findByUserId(userId: String): User?
}
