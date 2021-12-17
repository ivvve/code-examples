package com.tistory.devs0n.routing.product.exceptions

import com.tistory.devs0n.routing.product.domain.SKU

class ProductIsNotFoundException(
    sku: SKU
) : RuntimeException(
    "Product with the SKU is not found: ${sku.value}"
)
