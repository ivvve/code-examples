package com.tistory.devs0n.sample.integration

import io.kotest.core.listeners.AfterProjectListener
import io.kotest.core.listeners.BeforeProjectListener
import org.testcontainers.containers.GenericContainer

class RedisTestcontainersListener : BeforeProjectListener, AfterProjectListener {
    private val redisContainer = GenericContainer<Nothing>("redis:6.2-alpine").apply {
        withReuse(true) // to speed up container startup
        withExposedPorts(6379) // mapping port with Redis port (6379)
    }

    override suspend fun beforeProject() {
        this.redisContainer.start()
        System.setProperty("spring.redis.host", redisContainer.host)
        System.setProperty("spring.redis.port", redisContainer.firstMappedPort.toString())
    }

    override suspend fun afterProject() {
        this.redisContainer.close()
    }
}
