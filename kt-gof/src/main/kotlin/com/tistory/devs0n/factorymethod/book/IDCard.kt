package com.tistory.devs0n.factorymethod.book

class IDCard(
    private val owner: String,
) : Product {
    init {
        println("${this.owner}의 카드를 만듭니다")
    }

    override fun use() {
        println("${this.owner}의 카드를 사용합니다")
    }

    override fun getOwner(): String = this.owner
}
