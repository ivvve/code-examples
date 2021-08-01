package com.tistory.devs0n.lock.aop

import org.aspectj.lang.ProceedingJoinPoint
import org.aspectj.lang.annotation.Around
import org.aspectj.lang.annotation.Aspect
import org.aspectj.lang.reflect.MethodSignature
import org.redisson.api.RLock
import org.redisson.api.RedissonClient
import org.slf4j.LoggerFactory
import org.springframework.context.annotation.Configuration
import org.springframework.core.Ordered
import org.springframework.core.annotation.Order

@Aspect
@Configuration
@Order(Ordered.HIGHEST_PRECEDENCE)
class DistributedLockConfiguration(
    private val redissonClient: RedissonClient
) {
    @Around("@annotation(com.tistory.devs0n.lock.aop.DistributedLock)")
    fun distributedLockAdvice(joinPoint: ProceedingJoinPoint): Any? {
        val methodSignature = joinPoint.signature as MethodSignature
        val methodArgumentValues = joinPoint.args

        val lockConfiguration = this.getLockConfiguration(methodSignature)
        val lock = this.getLock(methodSignature, methodArgumentValues, lockConfiguration)

        val locked = lock.tryLock(lockConfiguration.waitTime, lockConfiguration.lockTime, lockConfiguration.timeUnit)

        if (!locked) {
            throw RuntimeException("Unable to get Lock - ${lock.name}")
        }

        LOGGER.info("Succeeded to get Lock - ${lock.name}")

        try {
            return joinPoint.proceed()
        } finally {
            lock.unlock()
            LOGGER.info("Unlock the Lock - ${lock.name}")
        }
    }

    private fun getLockConfiguration(methodSignature: MethodSignature): DistributedLock {
        return methodSignature.method.getAnnotation(DistributedLock::class.java)
    }

    private fun getLock(
        methodSignature: MethodSignature,
        methodArgumentValues: Array<Any>,
        lockConfiguration: DistributedLock
    ): RLock {
        val lockKey = this.getLockKey(methodSignature, methodArgumentValues)

        return when (lockConfiguration.type) {
            LockType.FAIR -> this.redissonClient.getFairLock(lockKey)
            LockType.NON_FAIR -> this.redissonClient.getLock(lockKey)
        }
    }

    private fun getLockKey(methodSignature: MethodSignature, methodArgumentValues: Array<Any>): String {
        val lockKeyBuilder = StringBuilder("lock")

        for (i in methodSignature.method.parameterAnnotations.indices) {
            val parameterAnnotations = methodSignature.method.parameterAnnotations[i]
            val isLockParameter = parameterAnnotations.any { it is LockParameter }

            // Get Lock name using `@LockParameter` annotations
            if (isLockParameter) {
                val lockParameter = parameterAnnotations.first { it is LockParameter } as LockParameter
                val parameterValue = methodArgumentValues[i]

                if (lockParameter.name.isBlank()) {
                    // If Parameter name is blank, use argument name
                    val parameterName = methodSignature.method.parameters[i].name
                    lockKeyBuilder.append(":${parameterName}:$parameterValue")
                } else {
                    lockKeyBuilder.append(":${lockParameter.name}:$parameterValue")
                }
            }
        }

        return lockKeyBuilder.toString()
    }

    companion object {
        private val LOGGER = LoggerFactory.getLogger(this::class.java)
    }
}
