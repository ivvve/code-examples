package io.github.ivvve.BridgePattern.`04`

interface Hello {
    fun greeting(): String
}

class EnglishHello : Hello {
    override fun greeting(): String {
        return "Hello"
    }
}

class KoreanHello : Hello {
    override fun greeting(): String {
        return "안녕하세요"
    }
}