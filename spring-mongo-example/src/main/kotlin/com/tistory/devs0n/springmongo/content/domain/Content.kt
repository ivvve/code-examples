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

    companion object {
        fun new(type: ContentType, title: String, description: String): Content =
            Content(type, ContentInformation(title, description))
    }
}
