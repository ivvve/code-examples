package com.tistory.devs0n.user.application

import com.tistory.devs0n.user.domain.TokenGenerator
import org.springframework.stereotype.Service

@Service
class TokenService(
    private val tokenGenerator: TokenGenerator
) {
    fun createToken(userId: String): String {
        return this.tokenGenerator.generate(userId)
    }
}