package io.github.ivvve.ProxyPattern

fun main() {
    val realSubject = RealSubject()
    val subjectProxy = SubjectProxy(realSubject)

    subjectProxy.action1()
    subjectProxy.action2()
}
