package com.tistory.devs0n.bridge.book

fun main() {
    val display1: Display = Display(StringDisplayImpl("Hello, Korea"))
    val display2: Display = CountDisplay(StringDisplayImpl("Hello, World"))
    val display3: CountDisplay = CountDisplay(StringDisplayImpl("Hello Universe"))

    display1.display()
    display2.display()
    display3.multiDisplay(5)
}
