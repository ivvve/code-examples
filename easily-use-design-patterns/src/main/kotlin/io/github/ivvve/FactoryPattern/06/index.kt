package io.github.ivvve.FactoryPattern.`06`

class Hello {
    fun greeting(): String {
        val korean = factory()
        return korean.text()
    }

    companion object {
        fun factory(): Korean {
            return Korean()
        }
    }
}

class Korean() {
    fun text(): String {
        return "안녕하세요"
    }
}
