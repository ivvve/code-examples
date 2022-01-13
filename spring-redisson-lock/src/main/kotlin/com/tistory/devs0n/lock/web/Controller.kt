package com.tistory.devs0n.lock.web

import com.tistory.devs0n.lock.TransactionMuukum
import com.tistory.devs0n.lock.order.OrderService
import com.tistory.devs0n.lock.product.ProductStockService

class Controller(
    private val transactionMuukum: TransactionMuukum,
    private val productStockService: ProductStockService,
    private val orderService: OrderService,
) {
    fun aa() {
        val a = this.transactionMuukum.process("hello") {
            this.productStockService.reduceMulti(listOf())
            this.orderService.order(OrderService.OrderCommand(1L, listOf()))
        }
    }
}
