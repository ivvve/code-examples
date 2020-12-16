package io.github.ivvve.ProxyPattern

interface Subject {
    fun action1()
    fun action2()
}

class RealSubject : Subject {
    init {
        println("객체: 생성")
    }

    override fun action1() {
        println("객체: action1")
    }

    override fun action2() {
        println("객체: action2")
    }
}
class SubjectProxy(private val subject: Subject) : Subject {
    init {
        println("대리자: 생성")
    }

    override fun action1() {
        println("대리자: action1")
        this.subject.action1()
    }

    override fun action2() {
        println("대리자: action2")
        this.subject.action2()
    }
}
