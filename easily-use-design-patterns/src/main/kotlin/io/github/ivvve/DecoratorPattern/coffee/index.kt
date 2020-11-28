package io.github.ivvve.DecoratorPattern.coffee

fun main() {
    val houseBlend = Mocha(HouseBlend())
    println(houseBlend.getDecryption())

    val espresso = Mocha(Mocha(Espresso()))
    println(espresso.getDecryption())
}