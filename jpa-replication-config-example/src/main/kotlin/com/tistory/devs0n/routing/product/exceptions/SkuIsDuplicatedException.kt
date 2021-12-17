package com.tistory.devs0n.routing.product.exceptions

import com.tistory.devs0n.routing.product.domain.SKU

class SkuIsDuplicatedException(
    sku: SKU
) : RuntimeException(
    "SKU is duplicated: ${sku.value}"
)
