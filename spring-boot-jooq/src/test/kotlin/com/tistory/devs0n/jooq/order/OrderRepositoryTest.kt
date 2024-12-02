package com.tistory.devs0n.jooq.order

import com.tistory.devs0n.jooq.test.IntegrationTestFunSpec
import io.kotest.matchers.bigdecimal.shouldBeEqualIgnoringScale
import io.kotest.matchers.shouldBe
import io.kotest.matchers.shouldNotBe

class OrderRepositoryTest(
    private val sut: OrderRepository,
) : IntegrationTestFunSpec({

    test("insert") {
        // when
        val result: Order = sut.insert(
            Order.new(
                userId = 1L,
                orderLines = listOf(
                    OrderLine.new(productId = 1L, quantity = 1, unitPrice = 10_000.toBigDecimal()),
                    OrderLine.new(productId = 2L, quantity = 2, unitPrice = 3_000.toBigDecimal()),
                ),
            )
        )

        // then
        // order
        result.id shouldNotBe null
        result.userId shouldBe 1L
        result.totalPrice shouldBeEqualIgnoringScale 16_000.toBigDecimal()
        result.createdAt shouldNotBe null
        result.updatedAt shouldNotBe null

        // orderLines
        result.orderLines.size shouldBe 2
        with(result.orderLines[0]) {
            id shouldNotBe null
            productId shouldBe 1L
            quantity shouldBe 1
            unitPrice shouldBeEqualIgnoringScale 10_000.toBigDecimal()
            createdAt shouldNotBe null
            updatedAt shouldNotBe null
        }
        with(result.orderLines[1]) {
            id shouldNotBe null
            productId shouldBe 2L
            quantity shouldBe 2
            unitPrice shouldBeEqualIgnoringScale 3_000.toBigDecimal()
            createdAt shouldNotBe null
            updatedAt shouldNotBe null
        }
    }

    test("update") {
        // given
        val order = sut.insert(
            Order.new(
                userId = 1L,
                orderLines = listOf(
                    OrderLine.new(productId = 1L, quantity = 1, unitPrice = 10_000.toBigDecimal()),
                    OrderLine.new(productId = 2L, quantity = 2, unitPrice = 3_000.toBigDecimal()),
                ),
            )
        )
        order.updateOrderLines(
            listOf(
                OrderLine.new(productId = 1L, quantity = 1, unitPrice = 10_000.toBigDecimal()),
                OrderLine.new(productId = 3L, quantity = 4, unitPrice = 2_000.toBigDecimal()),
                OrderLine.new(productId = 10L, quantity = 2, unitPrice = 3_000.toBigDecimal()),
            )
        )

        // then
        val result: Order = sut.update(order)
        // order
        result.id shouldBe order.id
        result.userId shouldBe order.userId
        result.totalPrice shouldBeEqualIgnoringScale 24_000.toBigDecimal()
        result.createdAt shouldBe order.createdAt // createdAt field not changed
        result.updatedAt shouldNotBe null

        // orderLines
        result.orderLines.size shouldBe 3
        with(result.orderLines[0]) {
            id shouldNotBe null
            productId shouldBe 1L
            quantity shouldBe 1
            unitPrice shouldBeEqualIgnoringScale 10_000.toBigDecimal()
            createdAt shouldNotBe null
            updatedAt shouldNotBe null
        }
        with(result.orderLines[1]) {
            id shouldNotBe null
            productId shouldBe 3L
            quantity shouldBe 4
            unitPrice shouldBeEqualIgnoringScale 2_000.toBigDecimal()
            createdAt shouldNotBe null
            updatedAt shouldNotBe null
        }
        with(result.orderLines[2]) {
            id shouldNotBe null
            productId shouldBe 10L
            quantity shouldBe 2
            unitPrice shouldBeEqualIgnoringScale 3_000.toBigDecimal()
            createdAt shouldNotBe null
            updatedAt shouldNotBe null
        }
    }
})
