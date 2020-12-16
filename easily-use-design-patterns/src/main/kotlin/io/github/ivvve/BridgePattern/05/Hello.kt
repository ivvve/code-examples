package io.github.ivvve.BridgePattern.`05`

// Implementation
interface Hello {
    fun greeting(): String
}

// Concrete Implementation
class EnglishHello : Hello {
    override fun greeting(): String {
        return "Hello"
    }
}

// Concrete Implementation
class KoreanHello : Hello {
    override fun greeting(): String {
        return "안녕하세요"
    }
}