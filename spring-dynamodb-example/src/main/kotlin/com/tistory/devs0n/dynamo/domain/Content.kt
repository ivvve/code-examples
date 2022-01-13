package com.tistory.devs0n.dynamo.domain

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTable
import org.springframework.data.annotation.Id
import java.util.*

@DynamoDBTable(tableName = "User")
class Content {
    @Id
    val id = UUID.randomUUID().toString()


}
