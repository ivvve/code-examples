package com.tistory.gateway.filters

import io.jsonwebtoken.*
import org.slf4j.LoggerFactory
import org.springframework.cloud.gateway.filter.GatewayFilter
import org.springframework.cloud.gateway.filter.factory.AbstractGatewayFilterFactory
import org.springframework.http.HttpHeaders
import org.springframework.http.HttpStatus
import org.springframework.http.server.reactive.ServerHttpRequest
import org.springframework.stereotype.Component
import org.springframework.web.server.ServerWebExchange
import reactor.core.publisher.Mono

@Component
class AuthorizationHeaderFilter : AbstractGatewayFilterFactory<AuthorizationHeaderFilter.Config>(Config::class.java) {
    data class Config(
        val secret: String
    )

    override fun shortcutFieldOrder() = mutableListOf("secret")

    override fun apply(config: Config): GatewayFilter {
        return GatewayFilter { exchange, chain ->
            val request = exchange.request

            val authToken = this.getAuthToken(request)
            if (authToken == null) {
                return@GatewayFilter this.onAuthError(exchange, "Authorization token not found")
            }

            val authTokenClaims = this.getAuthTokenClaimsFromAuthToken(authToken, config.secret)
            if (authTokenClaims == null) {
                return@GatewayFilter this.onAuthError(exchange, "Auth Token is inappropriate")
            }

            chain.filter(exchange)
        }
    }

    private fun getAuthToken(request: ServerHttpRequest): String? {
        if (!request.headers.containsKey(HttpHeaders.AUTHORIZATION)) {
            return null
        }

        val authorizationHeader = request.headers.getFirst(HttpHeaders.AUTHORIZATION)!!
        return authorizationHeader.replace("Bearer", "").trim()
    }

    private fun getAuthTokenClaimsFromAuthToken(authToken: String, secret: String): AuthTokenClaims? {
        val parsedClaims = this.parseAuthToken(authToken, secret)

        if (
            (parsedClaims == null) ||
            !parsedClaims.containsKey(AuthTokenClaims.USER_ID_CLAIMS_KEY)
        ) {
            return null
        }

        return AuthTokenClaims(parsedClaims[AuthTokenClaims.USER_ID_CLAIMS_KEY] as String)
    }

    private fun parseAuthToken(authToken: String, secret: String): Claims? {
        return try {
            Jwts.parser()
                .setSigningKey(secret)
                .parse(authToken)
                .body as Claims
        } catch (exception: Exception) {
            when (exception) {
                is ExpiredJwtException,
                is UnsupportedJwtException,
                is MalformedJwtException,
                is SignatureException -> null

                else -> throw exception
            }
        }
    }

    private fun onAuthError(exchange: ServerWebExchange, message: String): Mono<Void> {
        LOGGER.error("Auth error $message")
        exchange.response.statusCode = HttpStatus.UNAUTHORIZED
        return exchange.response.setComplete()
    }

    companion object {
        private val LOGGER = LoggerFactory.getLogger(this::class.java)
    }
}
