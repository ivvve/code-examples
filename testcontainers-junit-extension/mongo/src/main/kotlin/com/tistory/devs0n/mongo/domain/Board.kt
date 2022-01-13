package com.tistory.devs0n.mongo.domain

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document
import org.springframework.data.mongodb.core.mapping.Field
import org.springframework.data.mongodb.core.mapping.FieldType

@Document("boards")
class Board {
    @Id
    @Field(name = "_id", targetType = FieldType.OBJECT_ID)
    var id: String? = null

    @Field(name = "title")
    val title: String

    @Field(name = "content")
    val content: String

    constructor(title: String, content: String) {
        this.title = title
        this.content = content
    }
}
