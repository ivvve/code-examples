package com.tistory.devs0n.gateway.filters.throttling

import org.springframework.cloud.gateway.filter.GatewayFilter
import org.springframework.cloud.gateway.filter.factory.AbstractGatewayFilterFactory
import org.springframework.cloud.gateway.filter.ratelimit.KeyResolver
import org.springframework.cloud.gateway.filter.ratelimit.RateLimiter
import org.springframework.cloud.gateway.filter.ratelimit.RedisRateLimiter
import org.springframework.cloud.gateway.support.HasRouteId
import org.springframework.http.HttpStatus
import org.springframework.http.MediaType
import org.springframework.http.server.reactive.ServerHttpResponse
import org.springframework.stereotype.Component
import reactor.core.publisher.Mono

@Component
class ApiThrottlingFilter(
    private val rateLimiter: RateLimiter<RedisRateLimiter.Config>,
) : AbstractGatewayFilterFactory<ApiThrottlingFilter.Config>(Config::class.java) {
    class Config(
        val keyResolver: KeyResolver,
    ) : HasRouteId {
        private var routeId: String? = null

        override fun getRouteId(): String = this.routeId!!

        override fun setRouteId(routeId: String) {
            this.routeId = routeId
        }
    }

    override fun apply(config: Config): GatewayFilter {
        return GatewayFilter { exchange, chain ->
            val response = exchange.response
            val keyResolver = config.keyResolver
            val routeId = config.routeId

            return@GatewayFilter keyResolver.resolve(exchange)
                .flatMap { key ->
                    return@flatMap this.rateLimiter.isAllowed(routeId, key)

                }.flatMap { rateLimitResponse ->
                    return@flatMap when (rateLimitResponse.isAllowed) {
                        true -> chain.filter(exchange)
                        false -> this.responseTooManyRequest(response)
                    }
                }
        }
    }

    private fun responseTooManyRequest(response: ServerHttpResponse): Mono<Void> {
        response.statusCode = HttpStatus.TOO_MANY_REQUESTS
        response.headers.contentType = MediaType.APPLICATION_JSON
        return response.writeWith(
            Mono.just(
                response.bufferFactory().wrap(
                    """{
                        |"success": false,
                        |"message":"You sent too many requests"
                    |}""".trimMargin().toByteArray()
                )
            )
        )
    }
}
