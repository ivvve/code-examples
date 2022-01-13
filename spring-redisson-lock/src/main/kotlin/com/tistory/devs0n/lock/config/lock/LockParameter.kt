package com.tistory.devs0n.lock.config.lock

@Target(AnnotationTarget.VALUE_PARAMETER)
@Retention(AnnotationRetention.RUNTIME)
annotation class LockParameter(
    val name: String = ""
)
