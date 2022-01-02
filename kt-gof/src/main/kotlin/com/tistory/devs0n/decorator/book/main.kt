package com.tistory.devs0n.decorator.book

fun main() {
    val d1 = StringDisplay("Hello, World!")
    d1.show()

    println("--------------------------------")

    val d2 = SideBorder('#', d1)
    d2.show()

    println("--------------------------------")

    val d3 = SideBorder('$', d2)
    d3.show()

    println("--------------------------------")

    val d4 = FullBorder(d3)
    d4.show()

    println("--------------------------------")

    val d5 = SideBorder('*', d4)
    d5.show()
}
