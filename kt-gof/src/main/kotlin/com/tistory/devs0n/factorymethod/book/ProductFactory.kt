package com.tistory.devs0n.factorymethod.book

/**
 * Product를 만든다.
 * 자신이 만든 Product는 등록해둔다.
 */
abstract class ProductFactory {
    fun create(owner: String): Product {
        val product = this.createProduct(owner)
        this.registerProduct(product)
        return product
    }

    protected abstract fun createProduct(owner: String): Product

    protected abstract fun registerProduct(product: Product)
}
