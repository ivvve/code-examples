package io.github.ivvve.FactoryPattern.`02`

class Hello {
    fun greeting(): String {
        val korean = Korean()
        return korean.text()
    }
}

class Korean {
    fun text(): String {
        return "안녕하세요"
    }
}

fun main() {
    val hello = Hello()
    println(hello.greeting())
}