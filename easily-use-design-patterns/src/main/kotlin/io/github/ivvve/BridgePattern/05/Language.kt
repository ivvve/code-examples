package io.github.ivvve.BridgePattern.`05`

// Abstract
abstract class Language(protected val hello: Hello) {
    abstract fun greeting(): String
}

// Refined Abstract
class Message(hello: Hello) : Language(hello) {
    override fun greeting(): String {
        return super.hello.greeting()
    }
}