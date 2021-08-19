package com.tistory.devs0n.reactmongo.content

import kotlinx.coroutines.reactor.awaitSingle
import kotlinx.coroutines.reactor.awaitSingleOrNull
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class ContentService(
    private val contentRepository: ContentRepository
) {
    suspend fun getContent(id: String): Content =
        this.contentRepository.findById(id).awaitSingleOrNull()
            ?: throw IllegalArgumentException("Content not found (id: $id)")

    suspend fun getContentsOf(type: ContentType): List<Content> = this.contentRepository.findByType(type)

    @Transactional
    suspend fun createContent(type: ContentType, title: String, description: String): Content {
        return this.contentRepository.save(Content(type, title, description)).awaitSingle()
    }

    @Transactional
    suspend fun createContentAndThrow(type: ContentType, title: String, description: String): Content {
        this.contentRepository.save(Content(type, title, description)).awaitSingle()
        throw RuntimeException("RuntimeException after save")
    }

    @Transactional
    suspend fun deleteContent(id: String) {
        this.contentRepository.deleteById(id).awaitSingleOrNull()
    }
}
