package io.github.ivvve.security.config.security

import io.github.ivvve.security.domain.Customer
import org.springframework.security.core.GrantedAuthority
import org.springframework.security.core.authority.SimpleGrantedAuthority
import org.springframework.security.core.userdetails.UserDetails

class CustomerUserDetails(
    private val customer: Customer
) : UserDetails {
    override fun getAuthorities(): MutableCollection<out GrantedAuthority> {
        return this.customer.authorities
            .map { SimpleGrantedAuthority(it.name) }
            .toMutableList()
    }

    override fun getPassword(): String {
        return this.customer.pwd
    }

    override fun getUsername(): String {
        return this.customer.email
    }

    override fun isAccountNonExpired(): Boolean {
        return true
    }

    override fun isAccountNonLocked(): Boolean {
        return true
    }

    override fun isCredentialsNonExpired(): Boolean {
        return true
    }

    override fun isEnabled(): Boolean {
        return true
    }
}