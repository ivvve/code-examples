package com.tistory.devs0n.jooq.order

import com.tistory.devs0n.jooq.product.Product
import com.tistory.devs0n.jooq.product.ProductRepository
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class OrderService(
    private val productRepository: ProductRepository,
    private val orderRepository: OrderRepository,
) {

    @Transactional
    fun placeOrder(command: Command): Order {
        val products = this.reduceProductStockQuantity(command)
        return this.orderRepository.insert(command.toEntity(products))
    }

    private fun reduceProductStockQuantity(command: Command): List<Product> {
        val products = this.productRepository.getAllByIds(command.getProductIds())

        command.orderLines.map { it.productId to it.quantity }
            .forEach { (productId: Long, quantity: Int) ->
                val product = products.find { it.id == productId }!!
                product.reduceStockQuantity(quantity)
            }

        return this.productRepository.updateAll(products)
    }

    data class Command(
        val userId: Long,
        val orderLines: List<OrderLineCommand>,
    ) {
        data class OrderLineCommand(
            val productId: Long,
            val quantity: Int,
        )

        fun getProductIds(): List<Long> {
            return this.orderLines.map { it.productId }
        }

        fun toEntity(products: List<Product>): Order {
            val productsById = products.associateBy { it.id!! }

            return Order.new(
                userId = userId,
                orderLines = this.orderLines.map {
                    OrderLine.new(
                        productId = it.productId,
                        quantity = it.quantity,
                        unitPrice = productsById[it.productId]!!.unitPrice,
                    )
                }
            )
        }
    }
}
