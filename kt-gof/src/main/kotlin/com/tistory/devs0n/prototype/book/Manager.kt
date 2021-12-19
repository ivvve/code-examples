package com.tistory.devs0n.prototype.book

/**
 * Product들을 관리하고 새로 생성하는 객체
 */
class Manager {
    private val showcase: MutableMap<String, Product> = mutableMapOf()

    fun register(name: String, proto: Product) {
        this.showcase[name] = proto
    }

    fun create(protoName: String): Product =
        this.showcase[protoName]?.createClone()
            ?: throw IllegalArgumentException("Product with the name not exists: $protoName")
}
