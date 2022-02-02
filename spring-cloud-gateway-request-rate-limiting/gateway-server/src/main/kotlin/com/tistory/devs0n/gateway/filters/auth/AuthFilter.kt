package com.tistory.devs0n.gateway.filters.auth

import org.springframework.cloud.gateway.filter.GatewayFilter
import org.springframework.cloud.gateway.filter.factory.AbstractGatewayFilterFactory
import org.springframework.http.HttpStatus
import org.springframework.http.MediaType
import org.springframework.http.server.reactive.ServerHttpRequest
import org.springframework.http.server.reactive.ServerHttpResponse
import org.springframework.stereotype.Component
import reactor.core.publisher.Mono

@Component
class AuthFilter : AbstractGatewayFilterFactory<AuthFilter.Config>(Config::class.java) {
    data class Config(
        val whiteList: Map<String, String>, // key: 인증 토큰, key: User ID
    )

    override fun apply(config: Config): GatewayFilter {
        return GatewayFilter { exchange, chain ->
            val request = exchange.request
            val response = exchange.response
            val whiteList = config.whiteList

            if (this.hasValidAuthToken(request, whiteList)) {
                val userId = this.extractUserIdFromRequest(request, whiteList)

                return@GatewayFilter chain.filter(
                    exchange.mutate()
                        .request(
                            request.mutate()
                                .header("X-USER-ID", userId)
                                .build()
                        )
                        .build()
                )
            }

            return@GatewayFilter this.responseInvalidAuthToken(response)
        }
    }

    private fun hasValidAuthToken(request: ServerHttpRequest, whiteList: Map<String, String>): Boolean {
        val authToken = request.headers.getFirst("X-AUTH-TOKEN")
        return authToken?.let { whiteList.containsKey(it) } == true
    }

    private fun extractUserIdFromRequest(request: ServerHttpRequest, whiteList: Map<String, String>): String {
        val authToken = request.headers.getFirst("X-AUTH-TOKEN")!!
        return whiteList[authToken]!!
    }

    private fun responseInvalidAuthToken(response: ServerHttpResponse): Mono<Void> {
        response.statusCode = HttpStatus.FORBIDDEN
        response.headers.contentType = MediaType.APPLICATION_JSON
        return response.writeWith(
            Mono.just(
                response.bufferFactory().wrap(
                    """{
                        |"success": false,
                        |"message":"Invalid Auth Token"
                    |}""".trimMargin().toByteArray()
                )
            )
        )
    }
}
