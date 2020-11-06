package io.github.ivvve.FactoryPattern.`03`

class Hello(
    private val korean: Korean
) {
    fun greeting(): String {
        return this.korean.text()
    }
}

class Korean {
    fun text(): String {
        return "안녕하세요"
    }
}

fun main() {
    val korean = Korean()
    val hello = Hello(korean)
    println(hello.greeting())
}