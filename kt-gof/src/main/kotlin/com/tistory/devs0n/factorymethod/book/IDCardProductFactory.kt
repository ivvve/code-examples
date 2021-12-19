package com.tistory.devs0n.factorymethod.book

/**
 * IDCard를 만드는 팩토리 클래스
 */
class IDCardProductFactory : ProductFactory() {
    private val owners: MutableList<String> = mutableListOf()

    override fun createProduct(owner: String): Product = IDCard(owner)

    override fun registerProduct(product: Product) {
        this.owners.add(product.getOwner())
    }
}
