package com.tistory.devs0n.templatemethod.book

fun main() {
    val display1: Display = CharDisplay('S')
    display1.display()

    println("=====")


    val display2: Display = StringDisplay("Hello, World!")
    display2.display()
}
