package com.example.cloudgatewayservice.config.filter

import org.slf4j.LoggerFactory
import org.springframework.cloud.gateway.filter.GatewayFilter
import org.springframework.cloud.gateway.filter.OrderedGatewayFilter
import org.springframework.cloud.gateway.filter.factory.AbstractGatewayFilterFactory
import org.springframework.stereotype.Component
import reactor.core.publisher.Mono

@Component
class MyGlobalFilter : AbstractGatewayFilterFactory<MyGlobalFilter.Config>(Config::class.java) {
    class Config

    override fun apply(config: Config): GatewayFilter {
        return OrderedGatewayFilter(
            { exchange, chain ->
                LOGGER.info("GLOBAL LOG")
                chain.filter(exchange).then(Mono.empty())
            },
            2
        )
    }

    companion object {
        private val LOGGER = LoggerFactory.getLogger(this::class.java)
    }

}