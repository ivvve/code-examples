package com.tistory.devs0n.routing.product.domain

import org.springframework.stereotype.Component
import java.util.*

@Component
class SKUGenerator {
    fun generate(): SKU = SKU(UUID.randomUUID().toString())
}
