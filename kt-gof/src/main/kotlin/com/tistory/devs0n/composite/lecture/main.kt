package com.tistory.devs0n.composite.lecture

fun main() {
    val key = Item("Key", 400)
    val watch = Item("Watch", 2_000)

    val bag = Bag()
    bag.add(key)
    bag.add(watch)

    val biggerBag = Bag()
    biggerBag.add(bag)
    biggerBag.add(Item("Lock", 200))

    // Client는 구체적인 정보를 몰라도 Composite 인터페이스를 통해 가격을 알아낼 수 있다 (위임)
    Client(key).printPrice()
    Client(watch).printPrice()
    Client(bag).printPrice()
    Client(biggerBag).printPrice()
}
