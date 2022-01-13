package com.tistory.devs0n.enable.mongo.config

import com.tistory.devs0n.enable.mongo.EnableMyMongoDBModule
import org.springframework.beans.factory.annotation.Qualifier
import org.springframework.boot.autoconfigure.mongo.MongoProperties
import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.ImportAware
import org.springframework.core.type.AnnotationMetadata
import org.springframework.data.mongodb.MongoDatabaseFactory
import org.springframework.data.mongodb.MongoTransactionManager
import org.springframework.data.mongodb.config.EnableMongoAuditing
import org.springframework.data.mongodb.core.SimpleMongoClientDatabaseFactory
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories

//@Configuration
@EnableMongoAuditing
@EnableMongoRepositories(basePackages = ["com.tistory.devs0n.enable.mongo"])
class MyMongoDBConfiguration : ImportAware {
    override fun setImportMetadata(importMetadata: AnnotationMetadata) {
        TODO("Not yet implemented")
    }

    @Bean(name = ["myMongoProperties"])
    @ConfigurationProperties(prefix = "my.spring.data.mongodb.uri")
    fun mongoProperties(): MongoProperties {
        return MongoProperties()
    }

    @Bean(name = ["myMongoClientDatabaseFactory"])
    fun mongoDatabaseFactory(
        @Qualifier("myMongoProperties") mongoProperties: MongoProperties
    ): MongoDatabaseFactory {
        return SimpleMongoClientDatabaseFactory(mongoProperties.uri)
    }

    @Bean(name = ["myMongoTransactionManager"])
    fun transactionManager(@Qualifier("myMongoProperties") mongoDatabaseFactory: MongoDatabaseFactory): MongoTransactionManager {
        return MongoTransactionManager()
    }
}
