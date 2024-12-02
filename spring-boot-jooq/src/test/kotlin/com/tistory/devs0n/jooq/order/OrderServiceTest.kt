package com.tistory.devs0n.jooq.order

import com.tistory.devs0n.jooq.product.Product
import com.tistory.devs0n.jooq.product.ProductRepository
import com.tistory.devs0n.jooq.test.IntegrationTestFunSpec
import io.kotest.matchers.bigdecimal.shouldBeEqualIgnoringScale
import io.kotest.matchers.collections.shouldHaveSize
import io.kotest.matchers.shouldBe
import io.kotest.matchers.shouldNotBe

class OrderServiceTest(
    private val productRepository: ProductRepository,
    private val sut: OrderService,
) : IntegrationTestFunSpec({

    test("placeOrder") {
        // given
        val product1 = productRepository.insert(
            Product.new(name = "Jeans", unitPrice = 53_000.toBigDecimal(), stockQuantity = 40)
        )
        val product2 = productRepository.insert(
            Product.new(name = "T-shirt", unitPrice = 25_000.toBigDecimal(), stockQuantity = 100)
        )

        // when
        val result: Order = sut.placeOrder(
            OrderService.Command(
                userId = 1L,
                orderLines = listOf(
                    OrderService.Command.OrderLineCommand(productId = product1.id!!, quantity = 1),
                    OrderService.Command.OrderLineCommand(productId = product2.id!!, quantity = 2),
                ),
            )
        )

        // then
        result.id shouldNotBe null
        result.userId shouldBe 1L
        result.totalPrice shouldBeEqualIgnoringScale 103_000.toBigDecimal()
        result.orderLines shouldHaveSize 2
        with(result.orderLines[0]) {
            this.id shouldNotBe null
            this.productId shouldBe product1.id
            this.quantity shouldBe 1
            this.unitPrice shouldBeEqualIgnoringScale product1.unitPrice
            this.createdAt shouldNotBe null
            this.updatedAt shouldNotBe null
        }
        with(result.orderLines[1]) {
            this.id shouldNotBe null
            this.productId shouldBe product2.id
            this.quantity shouldBe 2
            this.unitPrice shouldBeEqualIgnoringScale product2.unitPrice
            this.createdAt shouldNotBe null
            this.updatedAt shouldNotBe null
        }

        val products = productRepository.findAllByIds(listOf(product1.id!!, product2.id!!))
        with(products[0]) {
            this.id shouldBe product1.id
            this.stockQuantity shouldBe 39
        }
        with(products[1]) {
            this.id shouldBe product2.id
            this.stockQuantity shouldBe 98
        }
    }
})
