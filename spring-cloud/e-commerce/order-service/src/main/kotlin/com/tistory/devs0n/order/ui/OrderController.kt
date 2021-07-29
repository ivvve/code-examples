package com.tistory.devs0n.order.ui

import com.tistory.devs0n.order.application.OrderService
import com.tistory.devs0n.order.ui.dto.CreateOrderRequest
import com.tistory.devs0n.order.ui.dto.OrderResponse
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import javax.validation.Valid

@RestController
class OrderController(
    private val orderService: OrderService
) {
    @GetMapping("/{userId}/orders")
    fun getUserOrders(@PathVariable userId: String): ResponseEntity<List<OrderResponse>> {
        val userOrders = this.orderService.getUserOrders(userId)
        return ResponseEntity.ok(userOrders.map { OrderResponse.of(it) })
    }

    @PostMapping("/{userId}/orders")
    fun createUserOrder(
        @PathVariable userId: String,
        @Valid @RequestBody request: CreateOrderRequest
    ): ResponseEntity<OrderResponse> {
        val order = this.orderService.createOrder(
            userId,
            request.productId,
            request.quantity,
            request.unitPrice,
        )
        return ResponseEntity.ok(OrderResponse.of(order))
    }
}
