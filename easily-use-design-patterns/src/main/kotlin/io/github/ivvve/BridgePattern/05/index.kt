package io.github.ivvve.BridgePattern.`05`

fun main() {
//    val lang: String? = "Korean"
    val lang: String? = null

    val language: Language = if (lang == "Korean") {
        Message(KoreanHello())
    } else {
        Message(EnglishHello())
    }

    println(language.greeting())
}