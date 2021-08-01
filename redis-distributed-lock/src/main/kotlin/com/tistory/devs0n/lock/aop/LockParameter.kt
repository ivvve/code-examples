package com.tistory.devs0n.lock.aop

@Target(AnnotationTarget.VALUE_PARAMETER)
@Retention(AnnotationRetention.RUNTIME)
annotation class LockParameter(
    val name: String = ""
)
