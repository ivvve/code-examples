package io.github.ivvve.security.domain

import org.springframework.data.jpa.repository.JpaRepository
import java.util.*

interface CustomerRepository : JpaRepository<Customer, Long> {
    fun findByEmail(email: String): Customer
}