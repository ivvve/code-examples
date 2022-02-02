package com.tistory.devs0n.gateway.filters

import org.springframework.cloud.gateway.filter.GatewayFilter
import org.springframework.cloud.gateway.filter.GatewayFilterChain
import org.springframework.cloud.gateway.filter.factory.AbstractGatewayFilterFactory
import org.springframework.http.HttpStatus
import org.springframework.http.MediaType
import org.springframework.http.server.reactive.ServerHttpRequest
import org.springframework.stereotype.Component
import org.springframework.web.server.ServerWebExchange
import reactor.core.publisher.Mono

@Component
class APIKeyFilter : AbstractGatewayFilterFactory<APIKeyFilter.Config>(Config::class.java) {
    data class Config(
        val exclude: List<String>
    )

    override fun apply(config: Config): GatewayFilter = GatewayFilter { exchange, chain ->
        val request = exchange.request

        if (this.isExcludedRequest(config, request)) {
            return@GatewayFilter chain.filter(exchange)
        }

        val apiKey = this.getApiKeyFrom(request)

        if (isValidApiKey(apiKey)) {
            val userId = extractUserIdFrom(apiKey!!)
            return@GatewayFilter this.routeUserId(exchange, chain, userId)
        }

        return@GatewayFilter this.responseInvalidApiKey(exchange, chain, apiKey)
    }

    private fun isExcludedRequest(config: Config, request: ServerHttpRequest): Boolean {

        return config.exclude.any {
            request.path.value().matches(Regex(it))
        }
    }

    private fun isValidApiKey(apiKey: String?): Boolean {
        return (apiKey != null) &&
                (apiKey.length == 10) &&
                apiKey.startsWith("user:")
    }

    private fun getApiKeyFrom(request: ServerHttpRequest): String? = request.headers.getFirst("X-API-KEY")

    private fun extractUserIdFrom(apiKey: String): Int = apiKey.split(":")[1].toInt()

    private fun routeUserId(exchange: ServerWebExchange, chain: GatewayFilterChain, userId: Int): Mono<Void> {
        return chain.filter(
            exchange.mutate()
                .request(
                    exchange.request.mutate()
                        .header("X-USER-ID", userId.toString())
                        .build()
                ).build()
        )
    }

    private fun responseInvalidApiKey(
        exchange: ServerWebExchange,
        chain: GatewayFilterChain,
        apiKey: String?
    ): Mono<Void> {
        val response = exchange.response
        response.statusCode = HttpStatus.UNAUTHORIZED
        response.headers.contentType = MediaType.APPLICATION_JSON
        return response.writeWith(
            Mono.just(
                response.bufferFactory().wrap("""{"message":"API Key is invalid: $apiKey"}""".toByteArray())
            )
        )
    }
}
