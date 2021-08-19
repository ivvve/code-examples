package com.tistory.devs0n.reactmongo.content

import org.springframework.data.repository.reactive.ReactiveCrudRepository

interface ContentRepository : ReactiveCrudRepository<Content, String> {
    suspend fun findByType(type: ContentType): List<Content>
}
