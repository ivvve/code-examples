package com.tistory.devs0n.user.domain

import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.stereotype.Component

@Component
class SecurityPasswordEncoder(
    private val passwordEncryptor: PasswordEncryptor
) : PasswordEncoder {
    override fun encode(rawPassword: CharSequence): String {
        return this.passwordEncryptor.encrypt(rawPassword.toString())
    }

    override fun matches(rawPassword: CharSequence, encodedPassword: String): Boolean {
        return this.passwordEncryptor.match(rawPassword.toString(), encodedPassword)
    }
}
