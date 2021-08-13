package com.tistory.devs0n.springmongo.content.domain

import org.springframework.data.mongodb.core.mapping.Document
import org.springframework.data.mongodb.core.mapping.Field

@Document
class ContentInformation {
    @Field("title")
    val title: String

    @Field("description")
    val description: String

    constructor(title: String, description: String) {
        this.title = title
        this.description = description
    }
}
