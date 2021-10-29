package com.devs0n.mongoinit.member

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document
import org.springframework.data.mongodb.core.mapping.Field
import org.springframework.data.mongodb.core.mapping.FieldType

@Document(collection = "members")
data class Member(
    @Field(name = "name")
    val name: String,

    @Field(name = "address")
    val address: String,
) {
    @Id
    @Field(name = "_id", targetType = FieldType.STRING)
    var id: String? = null
}
