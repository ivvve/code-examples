package io.github.ivvve.BridgePattern.`01`

class Hello {
    fun greeting(): String {
        return "Hello"
    }
}

fun main() {
    val hello = Hello()
    println(hello.greeting())
}