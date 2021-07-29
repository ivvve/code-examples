package com.tistory.devs0n.user.client

import org.springframework.cloud.openfeign.FeignClient
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable

@FeignClient(name = "order-service")
interface OrderServiceClient {
    @GetMapping("/{userId}/orders")
    fun getOrders(@PathVariable userId: String): List<OrderResponse>
}
