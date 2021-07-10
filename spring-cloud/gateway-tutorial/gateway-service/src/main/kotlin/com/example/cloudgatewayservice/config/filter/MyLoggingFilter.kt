package com.example.cloudgatewayservice.config.filter

import org.slf4j.LoggerFactory
import org.springframework.cloud.gateway.filter.GatewayFilter
import org.springframework.cloud.gateway.filter.OrderedGatewayFilter
import org.springframework.cloud.gateway.filter.factory.AbstractGatewayFilterFactory
import org.springframework.stereotype.Component
import reactor.core.publisher.Mono

@Component
class MyLoggingFilter : AbstractGatewayFilterFactory<MyLoggingFilter.Config>(Config::class.java) {
    data class Config(
        val message: String
    )

    // 없으면 YAML 설정 시 arg name을 지정해야함
    override fun shortcutFieldOrder(): MutableList<String> = mutableListOf("message")

    override fun apply(config: Config): GatewayFilter {
        return OrderedGatewayFilter(
            { exchange, chain ->
                LOGGER.info("Request ID: ${exchange.request.id}")

                LOGGER.info("Config message: ${config.message}")

                // return
                chain.filter(exchange).then(Mono.fromRunnable {
                    LOGGER.info("Response code: ${exchange.response.statusCode}")
                })
            },
            3
        )

    }

    companion object {
        private val LOGGER = LoggerFactory.getLogger(this::class.java)
    }
}
