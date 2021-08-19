package com.tistory.devs0n.reactmongo

import com.mongodb.ConnectionString
import org.springframework.boot.autoconfigure.mongo.MongoProperties
import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.data.mongodb.ReactiveMongoDatabaseFactory
import org.springframework.data.mongodb.ReactiveMongoTransactionManager
import org.springframework.data.mongodb.config.EnableMongoAuditing
import org.springframework.data.mongodb.core.SimpleReactiveMongoDatabaseFactory

@Configuration
@EnableMongoAuditing
class ReactiveMongoConfiguration {
    @Bean
    @ConfigurationProperties("spring.data.mongodb")
    fun properties(): MongoProperties {
        return MongoProperties()
    }

    @Bean
    fun mongoDatabaseFactory(properties: MongoProperties): ReactiveMongoDatabaseFactory {
        val connectionString = ConnectionString(properties.uri)
        return SimpleReactiveMongoDatabaseFactory(connectionString)
    }

    @Bean
    fun transactionManager(databaseFactory: ReactiveMongoDatabaseFactory): ReactiveMongoTransactionManager {
        return ReactiveMongoTransactionManager(databaseFactory)
    }
}
