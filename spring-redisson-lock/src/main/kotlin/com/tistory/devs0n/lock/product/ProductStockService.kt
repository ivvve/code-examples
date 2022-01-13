package com.tistory.devs0n.lock.product

class ProductStockService(
    private val productRepository: ProductRepository,
) {
    fun reduceMulti(commands: List<Command>): List<Product> {
        val products = this.productRepository.findAllByNumberIn(commands.map { it.productNumber })
        val productMap = products.map { it.number to it }.toMap()

        commands.forEach {
            val product = productMap[it.productNumber]
                ?: throw RuntimeException("ProductNotfound")
            product.reduceStock(it.quantity)
        }

        return this.productRepository.saveAll(products)
    }

    fun reduce(command: Command): Product {
        val product = this.productRepository.findByNumber(command.productNumber)
            ?: throw RuntimeException("ProductNotFound")

        product.reduceStock(command.quantity)
        return this.productRepository.save(product)
    }

    data class Command(
        val productNumber: Long,
        val quantity: Int,
    )
}
