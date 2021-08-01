package com.tistory.devs0n.lock.aop

import java.util.concurrent.TimeUnit

@Retention(AnnotationRetention.RUNTIME)
@Target(AnnotationTarget.FUNCTION)
annotation class DistributedLock(
    val lockTime: Long = 5,
    val waitTime: Long = 5,
    val timeUnit: TimeUnit = TimeUnit.SECONDS,
    val type: LockType = LockType.NON_FAIR,
)
