package io.github.ivvve.FactoryPattern.`05`

class Factory {
    companion object {
        fun getInstance(type: String): Message {
            return if (type == Message.KO) {
                Korean()
            } else {
                English()
            }
        }
    }
}

abstract class Message {
    abstract fun text(): String

    companion object {
        val KO = "ko"
        val EN = "en"
    }
}

class Korean : Message() {
    override fun text(): String {
        return "안녕하세요"
    }
}

class English : Message() {
    override fun text(): String {
        return "Hello"
    }
}
