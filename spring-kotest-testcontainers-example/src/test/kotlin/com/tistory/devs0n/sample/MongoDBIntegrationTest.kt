package com.tistory.devs0n.sample

import com.tistory.devs0n.sample.integration.IntegrationTest
import com.tistory.devs0n.sample.mongodb.MongoDBEntity
import com.tistory.devs0n.sample.mongodb.MongoDBEntityRepository
import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.collections.shouldHaveSize
import io.kotest.matchers.shouldBe

@IntegrationTest
class MongoDBIntegrationTest(
    private val mongodDBEntityRepository: MongoDBEntityRepository,
) : FunSpec({

    test("MongoDB integration test") {
        mongodDBEntityRepository.save(MongoDBEntity("mongodb"))
        mongodDBEntityRepository.findAll().apply {
            println(">>>>>> MongoDB data $this")
            this shouldHaveSize 1
            this.first().name shouldBe "mongodb"
        }
    }
})

