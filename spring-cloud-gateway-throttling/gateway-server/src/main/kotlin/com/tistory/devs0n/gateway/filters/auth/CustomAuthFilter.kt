package com.tistory.devs0n.gateway.filters.auth

import org.springframework.cloud.gateway.filter.GatewayFilter
import org.springframework.cloud.gateway.filter.factory.AbstractGatewayFilterFactory
import org.springframework.http.HttpStatus
import org.springframework.http.MediaType
import org.springframework.http.server.reactive.ServerHttpRequest
import org.springframework.stereotype.Component
import reactor.core.publisher.Mono

@Component
class CustomAuthFilter : AbstractGatewayFilterFactory<CustomAuthFilter.Config>(Config::class.java) {
    data class Config(
        val whiteList: Map<String, String>, // key: 인증 토큰, key: User ID
    )

    override fun apply(config: Config): GatewayFilter = GatewayFilter { exchange, chain ->
        val request = exchange.request
        val response = exchange.response

        if (this.isNotInWhiteList(request, config.whiteList)) {
            response.statusCode = HttpStatus.FORBIDDEN
            response.headers.contentType = MediaType.APPLICATION_JSON
            return@GatewayFilter response.writeWith(
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

        // 인증 토큰으로부터 User ID를 추출하여 Header에 User ID를 담아 API 서버로 전송
        request.mutate()
            .header("X-USER-ID", this.getUserIdFromHeader(request, config.whiteList))
        return@GatewayFilter chain.filter(exchange)
    }

    private fun isNotInWhiteList(request: ServerHttpRequest, whiteList: Map<String, String>): Boolean =
        !this.isInWhiteList(request, whiteList)

    private fun isInWhiteList(request: ServerHttpRequest, whiteList: Map<String, String>): Boolean {
        val authToken = request.headers.getFirst("X-AUTH-TOKEN")
            ?: return false

        return whiteList.containsKey(authToken)
    }

    private fun getUserIdFromHeader(request: ServerHttpRequest, whiteList: Map<String, String>): String {
        val authToken = request.headers.getFirst("X-AUTH-TOKEN")!!
        return whiteList[authToken]!!
    }
}
