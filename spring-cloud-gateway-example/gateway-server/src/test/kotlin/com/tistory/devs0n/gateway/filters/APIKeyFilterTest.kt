package com.tistory.devs0n.gateway.filters

import org.junit.jupiter.api.Assertions.*
import org.assertj.core.api.Assertions.*
import org.junit.jupiter.api.Test
import org.springframework.cloud.gateway.filter.GatewayFilter
import org.springframework.cloud.gateway.support.ServerWebExchangeUtils
import org.springframework.mock.http.server.reactive.MockServerHttpRequest
import org.springframework.mock.web.server.MockServerWebExchange

internal class APIKeyFilterTest {
    @Test
    fun `exclude test`() {
        val filter: GatewayFilter = APIKeyFilter().apply(APIKeyFilter.Config(listOf("/exclude/")))

        val request = MockServerHttpRequest.get("/users/1234").build()

        val exchange = MockServerWebExchange.from(request)


    }
}
