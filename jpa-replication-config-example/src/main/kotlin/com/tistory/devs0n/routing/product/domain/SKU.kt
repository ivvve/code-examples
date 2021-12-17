package com.tistory.devs0n.routing.product.domain

import com.tistory.devs0n.routing.common.utils.isNotUUID
import javax.persistence.Column
import javax.persistence.Embeddable

@Embeddable
data class SKU(
    @Column(name = "sku")
    val value: String
) {
    init {
        if (isNotUUID(this.value)) {
            throw IllegalArgumentException("SKU format error")
        }
    }
}
