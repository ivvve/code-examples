package com.tistory.devs0n.gateway.filters.throttling.resolver

import org.springframework.cloud.gateway.filter.ratelimit.KeyResolver
import org.springframework.stereotype.Component
import org.springframework.web.server.ServerWebExchange
import reactor.core.publisher.Mono

@Component("KeyAsUserIdResolver")
class KeyAsUserIdResolver : KeyResolver {
    override fun resolve(exchange: ServerWebExchange): Mono<String> {
        val userId = exchange.request.headers.getFirst("X-USER-ID")!!
        return Mono.just(userId)
    }
}
