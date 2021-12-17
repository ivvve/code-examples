package com.tistory.devs0n.routing.product.service

import com.tistory.devs0n.routing.common.utils.today
import com.tistory.devs0n.routing.product.domain.Product
import com.tistory.devs0n.routing.product.domain.ProductRepository
import com.tistory.devs0n.routing.product.domain.SKUGenerator
import com.tistory.devs0n.routing.product.exceptions.SkuIsDuplicatedException
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import java.time.Instant

@Service
class ProductRegistrationService(
    private val skuGenerator: SKUGenerator,
    private val productRepository: ProductRepository,
) {
    @Transactional
    fun registerProduct(command: RegisterProductCommand): Product {
        println("============== registerProduct 시작 ==============")
        val sku = this.skuGenerator.generate()

        if (this.productRepository.existsBySku(sku)) {
            throw SkuIsDuplicatedException(sku)
        }

        val product = Product(sku, command.manufacturingDate, today())
        return this.productRepository.save(product)
    }

    data class RegisterProductCommand(
        val manufacturingDate: Instant,
    )
}
