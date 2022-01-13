package com.tistory.devs0n.mongoquerydsl.content

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document
import org.springframework.data.mongodb.core.mapping.Field
import org.springframework.data.mongodb.core.mapping.FieldType

@Document(collection = "contents")
class Content {
    @Id
    @Field("_id", targetType = FieldType.OBJECT_ID)
    var id: String? = null

    @Field("title")
    val title: String

    @Field("description")
    val description: String

    constructor(title: String, description: String) {
        this.title = title
        this.description = description
    }
}
