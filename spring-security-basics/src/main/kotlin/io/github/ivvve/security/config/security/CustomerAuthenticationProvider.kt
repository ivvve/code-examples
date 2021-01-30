package io.github.ivvve.security.config.security

import org.springframework.security.authentication.AuthenticationProvider
import org.springframework.security.authentication.BadCredentialsException
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken
import org.springframework.security.core.Authentication
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.stereotype.Component

@Component
class CustomerAuthenticationProvider(
    private val customerUserDetailService: CustomerUserDetailService,
    private val passwordEncoder: PasswordEncoder // in WebSecurityConfig.passwordEncoder()
) : AuthenticationProvider {
    override fun authenticate(authentication: Authentication): Authentication {
        val username = authentication.principal.toString()
        val password = authentication.credentials.toString()

        val userDetails = this.customerUserDetailService.loadUserByUsername(username)

        if (!this.passwordEncoder.matches(password, userDetails.password)) {
            throw BadCredentialsException("Invalid Password!")
        }

        return UsernamePasswordAuthenticationToken(username, password, userDetails.authorities)
    }

    override fun supports(authentication: Class<*>?): Boolean {
        return authentication == UsernamePasswordAuthenticationToken::class.java
    }
}