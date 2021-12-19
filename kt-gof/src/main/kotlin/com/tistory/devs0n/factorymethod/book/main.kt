package com.tistory.devs0n.factorymethod.book

fun main() {
    val productFactory = IDCardProductFactory()
    val idCard1 = productFactory.create("Chris")
    val idCard2 = productFactory.create("Son")

    idCard1.use()
    idCard2.use()
}
