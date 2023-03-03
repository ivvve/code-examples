package com.tistory.devs0n.sample.redis

import org.springframework.data.redis.core.RedisHash
import javax.persistence.Id

@RedisHash
class RedisEntity {
    @Id
    var id: String? = null

    val name: String

    constructor(name: String) {
        this.name = name
    }

    override fun toString(): String {
        return "RedisEntity(id=$id, name='$name')"
    }
}
