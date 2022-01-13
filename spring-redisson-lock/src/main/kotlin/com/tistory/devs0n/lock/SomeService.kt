package com.tistory.devs0n.lock

import com.tistory.devs0n.lock.config.lock.DistributedLock
import com.tistory.devs0n.lock.config.lock.LockKey
import com.tistory.devs0n.lock.config.lock.LockParameter
import com.tistory.devs0n.lock.config.lock.LockType
import org.redisson.RedissonMultiLock
import org.redisson.api.RedissonClient
import org.springframework.stereotype.Service
import java.util.concurrent.TimeUnit

@Service
class SomeService(
    private val redissonClient: RedissonClient,
) {
    fun lock(commands: List<Command>) {
        if (commands.isEmpty()) {
            return
        }

        val productLocks = commands.map {
            this.redissonClient.getFairLock("product:${it.id}")
        }

        val lock = RedissonMultiLock(*productLocks.toTypedArray())
        val locked = lock.tryLock()

        if (!locked) {
            throw RuntimeException("Cannot get lock")
        }

        try {
            println("Good~")
        } finally {
            lock.unlock()
        }
    }

    data class Command(
        val id: String,
        val quantity: Int,
    )
}
