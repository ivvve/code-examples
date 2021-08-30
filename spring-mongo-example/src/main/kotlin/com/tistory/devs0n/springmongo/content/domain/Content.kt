package com.tistory.devs0n.springmongo.content.domain

import com.tistory.devs0n.springmongo.common.BaseDocumentEntity
import org.springframework.data.annotation.PersistenceConstructor
import org.springframework.data.mongodb.core.mapping.Document
import org.springframework.data.mongodb.core.mapping.Field

@Document(collection = "contents")
class Content : BaseDocumentEntity {
    @Field("type")
    val type: ContentType

    @Field("information")
    val information: ContentInformation

    @PersistenceConstructor
    private constructor(type: ContentType, information: ContentInformation) {
        this.type = type
        this.information = information
    }

    constructor(type: ContentType, title: String, description: String) :
            this(type, ContentInformation(title, description))

    fun informationString(): String = "Content(${this.id}) - ${this.type}, ${this.information}"
}

enum class ContentType {
    VIDEO,
    WEBTOON,
    NOVEL
}

data class ContentInformation(
    @Field("title")
    val title: String,

    @Field("description")
    val description: String,
)
