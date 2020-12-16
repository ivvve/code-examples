package io.github.ivvve.BridgePattern.`03`

open class Hello {
    fun greeting(): String {
        return "Hello"
    }
}

class Greeting : Hello() {
    fun ko(): String {
        return "안녕하세요"
    }
}

fun main() {
    val greeting = Greeting()
    println(greeting.ko())
    println(greeting.greeting())
}