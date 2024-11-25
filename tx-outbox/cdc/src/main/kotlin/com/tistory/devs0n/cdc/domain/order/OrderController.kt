package com.tistory.devs0n.cdc.domain.order

import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/orders")
class OrderController(
    private val orderService: OrderService,
) {
    @PostMapping
    fun placeOrder(@RequestBody request: PlaceOrderRequest) {
        this.orderService.placeOrder(
            productId = request.productId,
            quantity = request.quantity,
        )
    }
}

data class PlaceOrderRequest(
    val productId: String,
    val quantity: Int,
)
