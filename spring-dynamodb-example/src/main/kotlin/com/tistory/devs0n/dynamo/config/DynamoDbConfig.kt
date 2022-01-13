package com.tistory.devs0n.dynamo.config

import com.amazonaws.services.dynamodbv2.AmazonDynamoDB
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapperConfig
import org.socialsignin.spring.data.dynamodb.repository.config.EnableDynamoDBRepositories
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
@EnableDynamoDBRepositories
class DynamoDbConfig {
    @Bean
    fun amazonDynamoDB(): AmazonDynamoDB = AmazonDynamoDBClientBuilder.defaultClient()

    @Bean
    fun dynamoDBMapperConfig(): DynamoDBMapperConfig = DynamoDBMapperConfig.DEFAULT

    @Bean
    fun dynamoDBMapper(amazonDynamoDB: AmazonDynamoDB, dynamoDBMapperConfig: DynamoDBMapperConfig): DynamoDBMapper =
        DynamoDBMapper(amazonDynamoDB, dynamoDBMapperConfig)
}
