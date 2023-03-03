package com.tistory.devs0n.sample.mongodb

import org.springframework.data.mongodb.core.mapping.Document
import javax.persistence.Id

@Document
class MongoDBEntity {
    @Id
    var id: String? = null

    val name: String

    constructor(name: String) {
        this.name = name
    }

    override fun toString(): String {
        return "MongoDBEntity(id=$id, name='$name')"
    }
}
