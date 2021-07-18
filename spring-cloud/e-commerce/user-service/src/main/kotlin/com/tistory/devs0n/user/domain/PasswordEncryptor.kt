package com.tistory.devs0n.user.domain

import org.springframework.security.crypto.argon2.Argon2PasswordEncoder
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.stereotype.Component

@Component
class PasswordEncryptor {
    val encoder = Argon2PasswordEncoder()

    fun encrypt(password: String): String {
        return this.encoder.encode(password)
    }

    fun match(password: String, encryptedPassword: String): Boolean {
        return encoder.matches(password, encryptedPassword)
    }
}
