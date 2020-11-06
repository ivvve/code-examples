package io.github.ivvve.FactoryPattern.`05`

class Hello {
    fun greeting(type: String): String {
        val korean = Factory.getInstance(type)
        return korean.text()
    }
}

fun main() {
    val hello = Hello()
    println(hello.greeting("kr"))
    println(hello.greeting("en"))
}