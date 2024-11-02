package com.tistory.devs0n.parameter.config

import org.springframework.context.annotation.Configuration
import org.springframework.core.MethodParameter
import org.springframework.core.ReactiveAdapterRegistry
import org.springframework.web.reactive.BindingContext
import org.springframework.web.reactive.result.method.HandlerMethodArgumentResolverSupport
import org.springframework.web.server.ServerWebExchange
import reactor.core.publisher.Mono
import reactor.kotlin.core.publisher.toMono

@Configuration
class WebfluxConfiguration(
    adapterRegistry: ReactiveAdapterRegistry,
) : HandlerMethodArgumentResolverSupport(adapterRegistry) {

    override fun supportsParameter(parameter: MethodParameter): Boolean {
        return parameter.parameterType == LoginUser::class.java
    }

    override fun resolveArgument(
        parameter: MethodParameter,
        bindingContext: BindingContext,
        exchange: ServerWebExchange
    ): Mono<Any> {
        val userId = exchange.request.headers["X-USER-ID"]?.firstOrNull()?.toLongOrNull()
            ?: throw IllegalArgumentException("X-USER-ID header is required")
        return LoginUser(userId).toMono()
    }
}
