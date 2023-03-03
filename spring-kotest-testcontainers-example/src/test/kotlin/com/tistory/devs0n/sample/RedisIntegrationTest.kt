package com.tistory.devs0n.sample

import com.tistory.devs0n.sample.integration.IntegrationTest
import com.tistory.devs0n.sample.redis.RedisEntity
import com.tistory.devs0n.sample.redis.RedisEntityRepository
import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.collections.shouldHaveSize
import io.kotest.matchers.shouldBe

@IntegrationTest
class RedisIntegrationTest(
    private val redisEntityRepository: RedisEntityRepository,
) : FunSpec({

    test("Redis integration test") {
        redisEntityRepository.save(RedisEntity("redis"))

        redisEntityRepository.findAll().apply {
            this shouldHaveSize 1
            this.first().name shouldBe "redis"
        }
    }
})
