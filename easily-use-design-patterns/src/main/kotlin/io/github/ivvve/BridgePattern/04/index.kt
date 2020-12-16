package io.github.ivvve.BridgePattern.`04`

fun main() {
    val language = Language()

    language.english = EnglishHello()
    println(language.english!!.greeting())

    language.korean = KoreanHello()
    println(language.korean!!.greeting())
}