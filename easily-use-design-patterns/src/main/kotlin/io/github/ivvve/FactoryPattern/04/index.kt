package io.github.ivvve.FactoryPattern.`04`

class Korean() {
    fun text(): String {
        return "안녕하세요"
    }
}

class Factory {
    companion object {
        fun getInstance(): Korean {
            return Korean()
        }
    }
}

class Hello {
    fun greeting(): String {
//        val korean = Korean()
//        return korean.text()

        val korean = Factory.getInstance()
        return korean.text()
    }
}