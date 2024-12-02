package com.tistory.devs0n.jooq.product

import com.tistory.devs0n.jooq.test.IntegrationTestFunSpec
import io.kotest.matchers.bigdecimal.shouldBeEqualIgnoringScale
import io.kotest.matchers.shouldBe
import io.kotest.matchers.shouldNotBe

class ProductRepositoryTest(
    private val sut: ProductRepository,
) : IntegrationTestFunSpec({

    test("insert") {
        // when
        val result: Product = sut.insert(
            Product.new(
                name = "Jeans",
                unitPrice = 53_000.toBigDecimal(),
                stockQuantity = 40,
            )
        )

        // then
        result.id shouldNotBe null
        result.name shouldBe "Jeans"
        result.unitPrice shouldBeEqualIgnoringScale 53_000.toBigDecimal()
        result.stockQuantity shouldBe 40
        result.createdAt shouldNotBe null
        result.updatedAt shouldNotBe null
    }

    test("updateAll") {
        // given
        val product1 = sut.insert(Product.new(name = "Jeans", unitPrice = 53_000.toBigDecimal(), stockQuantity = 40))
        val product2 = sut.insert(Product.new(name = "T-shirt", unitPrice = 25_000.toBigDecimal(), stockQuantity = 100))

        // when
        product1.reduceStockQuantity(1)
        product2.reduceStockQuantity(3)

        // then
        val result: List<Product> = sut.updateAll(listOf(product1, product2))
        result.size shouldBe 2
        with(result[0]) {
            id shouldBe product1.id
            name shouldBe "Jeans"
            unitPrice shouldBeEqualIgnoringScale 53_000.toBigDecimal()
            stockQuantity shouldBe 39
            createdAt shouldBe product1.createdAt // not changed
            updatedAt shouldNotBe null
        }
        with(result[1]) {
            id shouldBe product2.id
            name shouldBe "T-shirt"
            unitPrice shouldBeEqualIgnoringScale 25_000.toBigDecimal()
            stockQuantity shouldBe 97
            createdAt shouldBe product2.createdAt // not changed
            updatedAt shouldNotBe null
        }
    }

    test("getAllByIds") {
        // given
        val product1 = sut.insert(Product.new(name = "Jeans", unitPrice = 53_000.toBigDecimal(), stockQuantity = 40))
        val product2 = sut.insert(Product.new(name = "T-shirt", unitPrice = 25_000.toBigDecimal(), stockQuantity = 100))

        // when
        val result: List<Product> = sut.getAllByIds(listOf(product1.id!!, product2.id!!))

        // then
        result.size shouldBe 2
        result[0].id shouldBe product1.id
        result[1].id shouldBe product2.id
    }
})
