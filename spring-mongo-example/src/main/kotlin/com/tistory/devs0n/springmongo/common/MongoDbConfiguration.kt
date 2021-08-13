package com.tistory.devs0n.springmongo.common

import org.springframework.boot.autoconfigure.mongo.MongoProperties
import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.data.mongodb.MongoDatabaseFactory
import org.springframework.data.mongodb.MongoTransactionManager
import org.springframework.data.mongodb.config.EnableMongoAuditing
import org.springframework.data.mongodb.core.SimpleMongoClientDatabaseFactory


@Configuration
@EnableMongoAuditing
class MongoDbConfiguration {
    @Bean
    @ConfigurationProperties("spring.data.mongodb")
    fun properties(): MongoProperties {
        return MongoProperties()
    }

    @Bean
    fun mongoClientDatabaseFactory(properties: MongoProperties): SimpleMongoClientDatabaseFactory {
        return SimpleMongoClientDatabaseFactory(properties.uri)
    }

    @Bean
    fun transactionManager(databaseFactory: MongoDatabaseFactory): MongoTransactionManager {
        return MongoTransactionManager(databaseFactory)
    }
}
