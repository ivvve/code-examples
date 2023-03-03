package com.tistory.devs0n.sample.integration

import io.kotest.core.listeners.AfterProjectListener
import io.kotest.core.listeners.BeforeProjectListener
import org.testcontainers.containers.MongoDBContainer

class MongodbIntegrationListener : BeforeProjectListener, AfterProjectListener {
    val mongodbContainer = MongoDBContainer("mongo:6.0.4").apply {
        withReuse(true) // to speed up container startup
    }

    override suspend fun beforeProject() {
        this.mongodbContainer.start()
        System.setProperty("spring.data.mongodb.uri", mongodbContainer.replicaSetUrl)
    }

    override suspend fun afterProject() {
        this.mongodbContainer.close()
    }
}
