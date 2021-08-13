package com.tistory.devs0n.springmongo.content.domain

import org.springframework.data.mongodb.repository.MongoRepository

interface ContentRepository : MongoRepository<Content, String> {
    fun findAllByType(type: ContentType): List<Content>
}
