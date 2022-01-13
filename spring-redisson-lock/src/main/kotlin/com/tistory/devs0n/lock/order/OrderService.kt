package com.tistory.devs0n.lock.order

import org.redisson.RedissonMultiLock
import org.redisson.api.RedissonClient
import org.springframework.stereotype.Service
import java.util.concurrent.TimeUnit

@Service
class OrderService(
    private val orderRepository: OrderRepository,
    private val redissonClient: RedissonClient,
) {
    fun orderWithLock(command: OrderCommand) {
        val locks = command.getProductNumbers().map {
            this.redissonClient.getFairLock("product:${it}")
        }
        val multiLock = RedissonMultiLock(*locks.toTypedArray())

        val locked = multiLock.tryLock(5000, TimeUnit.SECONDS)

        if (!locked) {
            throw RuntimeException("Cannot get lock")
        }

        try {
            return this.order(command)
        } finally {
            multiLock.unlock()
        }
    }

    fun order(command: OrderCommand) {
        if (command.isEmpty()) {
            throw RuntimeException("NONO")
        }

        val order = Order(command.userId)


    }

    data class OrderCommand(
        val userId: Long,
        val products: List<OrderTargetProduct>,
    ) {
        data class OrderTargetProduct(
            val productNumber: Long,
            val quantity: Int,
        )

        fun isEmpty() = this.products.isEmpty()

        fun getProductNumbers(): List<Long> = this.products.map { it.productNumber }
    }
}
