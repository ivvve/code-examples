package com.devs0n.mongoinit

import org.junit.jupiter.api.extension.BeforeAllCallback
import org.junit.jupiter.api.extension.Extension
import org.junit.jupiter.api.extension.ExtensionContext
import org.testcontainers.containers.MongoDBContainer
import org.testcontainers.utility.MountableFile

class MongodbTestcontainersExtension : Extension, BeforeAllCallback {
    companion object {
        private val mongodbContainer: MongoDBContainer = MongoDBContainer("mongo:4.4")
    }

    override fun beforeAll(context: ExtensionContext?) {
        if (mongodbContainer.isRunning) {
            return
        }

        mongodbContainer.start()
        System.setProperty("spring.data.mongodb.uri", mongodbContainer.replicaSetUrl)

        // execute init script
        mongodbContainer.copyFileToContainer(MountableFile.forClasspathResource("init.js"), "/script/init.js")
        mongodbContainer.execInContainer("mongo", "/script/init.js")

        // it doesn't work...
//        mongodbContainer.copyFileToContainer(MountableFile.forClasspathResource("init.js"), "/docker-entrypoint-initdb.d/init.js")
    }
}
