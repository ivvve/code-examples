package io.github.ivvve.BridgePattern.`02`

class Hello {
    fun greeting(language: String): String {
        return if (language == "Korean") {
            "안녕하세요"
        } else {
            "Hello"
        }
    }
}

fun main() {
    val hello = Hello()
    println(hello.greeting("Korean"))
}