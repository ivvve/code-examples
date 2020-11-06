package io.github.ivvve.FactoryPattern.`01`

class Hello {
    fun greeting(): String {
        return "안녕하세요"
    }
}

fun main() {
    val hello = Hello()
    println(hello.greeting())
}