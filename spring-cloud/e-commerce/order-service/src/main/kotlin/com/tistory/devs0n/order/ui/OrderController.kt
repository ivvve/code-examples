package com.tistory.devs0n.order.ui

import com.tistory.devs0n.order.application.OrderService
import com.tistory.devs0n.order.ui.dto.CreateOrderRequest
import org.springframework.web.bind.annotation.*
import org.springframework.web.context.request.RequestContextHolder
import javax.validation.Valid

@RestController
class OrderController(
    private val orderService: OrderService
) {
    @GetMapping("/{userId}/orders")
    fun getUserOrders(@PathVariable userId: String) {
        this.orderService.getUserOrders(userId)
    }

    @PostMapping("/{userId}/orders")
    fun createUserOrder(@PathVariable userId: String, @Valid @RequestBody request: CreateOrderRequest) {
        val order = this.orderService.createOrder(
            userId,
            request.productId,
            request.quantity,
            request.unitPrice,
        )
    }
}

@RestControllerAdvice
class A {
    @ExceptionHandler(RuntimeException::class)
    fun a(exception: RuntimeException): String {
        val requestAttribute = RequestContextHolder.currentRequestAttributes()
        return "yabal"
    }
}
