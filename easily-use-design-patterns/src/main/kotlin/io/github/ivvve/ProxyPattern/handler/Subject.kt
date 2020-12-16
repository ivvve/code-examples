package io.github.ivvve.ProxyPattern.handler

interface Subject {
    fun action1()
    fun action2()
}

class SubjectProxy(private val subject: Subject) : Subject {
    override fun action1() {
        TODO("Not yet implemented")
    }

    override fun action2() {
        TODO("Not yet implemented")
    }
}