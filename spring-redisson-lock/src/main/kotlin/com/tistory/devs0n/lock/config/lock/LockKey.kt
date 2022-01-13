package com.tistory.devs0n.lock.config.lock

@Target(AnnotationTarget.VALUE_PARAMETER, AnnotationTarget.FIELD)
@Retention(AnnotationRetention.RUNTIME)
annotation class LockKey(
    val name: String = ""
)
