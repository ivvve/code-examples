package io.github.ivvve.security.config.security

import io.github.ivvve.security.domain.CustomerRepository
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.security.core.userdetails.UsernameNotFoundException
import org.springframework.stereotype.Service

@Service
class CustomerUserDetailService(
    private val customerRepository: CustomerRepository
) : UserDetailsService {

    override fun loadUserByUsername(username: String?): UserDetails {
        val customer = this.customerRepository.findByEmail(username!!)
            ?: throw UsernameNotFoundException("$username not found!")
        return CustomerUserDetails(customer)
    }
}