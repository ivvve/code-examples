package com.tistory.devs0n.reactmongo.content

import org.springframework.data.annotation.CreatedDate
import org.springframework.data.annotation.Id
import org.springframework.data.annotation.LastModifiedDate
import org.springframework.data.annotation.PersistenceConstructor
import org.springframework.data.mongodb.core.mapping.Document
import org.springframework.data.mongodb.core.mapping.Field
import org.springframework.data.mongodb.core.mapping.FieldType
import java.time.LocalDateTime

@Document("contents")
class Content {
    @Id
    @Field("_id", targetType = FieldType.OBJECT_ID)
    var id: String? = null
        private set

    @Field("type")
    val type: ContentType

    @Field("info")
    val information: ContentInformation

    @CreatedDate
    @Field("created_at")
    var createdAt: LocalDateTime = LocalDateTime.now()
        private set

    @LastModifiedDate
    @Field("updated_at")
    var updatedAt: LocalDateTime = LocalDateTime.now()
        private set

    constructor(type: ContentType, title: String, description: String) :
            this(type, ContentInformation(title, description))

    @PersistenceConstructor
    private constructor(type: ContentType, information: ContentInformation) {
        this.type = type
        this.information = information
    }
}

enum class ContentType {
    NOVEL,
    VIDEO,
    WEBTOON;
}

data class ContentInformation(
    @Field("title")
    val title: String,

    @Field("desc")
    val description: String,
)
