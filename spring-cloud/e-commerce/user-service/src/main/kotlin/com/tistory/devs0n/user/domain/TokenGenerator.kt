package com.tistory.devs0n.user.domain

import io.jsonwebtoken.Jwts
import io.jsonwebtoken.SignatureAlgorithm
import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Component
import java.time.LocalDateTime
import java.time.ZoneId
import java.util.*

@Component
class TokenGenerator(
    @Value("\${config.auth.secret}") private val secret: String,
    @Value("\${config.auth.token-expiration-hour}") private val tokenExpirationHour: Long,
) {
    fun generate(userId: String): String {
        return Jwts.builder()
            .signWith(SignatureAlgorithm.HS512, this.secret)
            .claim("user_id", userId)
            .setExpiration(this.getExpirationDate())
            .compact()
    }

    fun getExpirationDate(): Date {
        return Date.from(
            LocalDateTime.now().plusHours(this.tokenExpirationHour)
                .atZone(ZoneId.systemDefault()).toInstant()
        )
    }
}
