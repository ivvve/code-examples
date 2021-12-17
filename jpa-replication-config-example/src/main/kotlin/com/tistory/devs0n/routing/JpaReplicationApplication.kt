package com.tistory.devs0n.routing

import com.tistory.devs0n.routing.common.utils.today
import com.tistory.devs0n.routing.product.service.ProductReadService
import com.tistory.devs0n.routing.product.service.ProductRegistrationService
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class JpaReplicationApplication

fun main(args: Array<String>) {
    val ac = runApplication<JpaReplicationApplication>(*args)

    val productRegistrationService = ac.getBean(ProductRegistrationService::class.java)
    val productReadService = ac.getBean(ProductReadService::class.java)

    println("====")
    val product = productRegistrationService.registerProduct(ProductRegistrationService.RegisterProductCommand(today()))
    println("====")
    productReadService.getProductBySKU(ProductReadService.GetProductBySKUQuery(product.sku))
    println("====")
}
