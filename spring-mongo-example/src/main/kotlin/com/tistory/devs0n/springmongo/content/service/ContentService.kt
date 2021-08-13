package com.tistory.devs0n.springmongo.content.service

import com.tistory.devs0n.springmongo.content.domain.Content
import com.tistory.devs0n.springmongo.content.domain.ContentRepository
import com.tistory.devs0n.springmongo.content.domain.ContentType
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional


@Service
class ContentService(
    private val contentRepository: ContentRepository
) {
    @Transactional
    fun createContent(type: ContentType, title: String, description: String): Content {
        return this.contentRepository.save(Content.new(type, title, description))
    }

    @Transactional
    fun createContentAndThrow(type: ContentType, title: String, description: String): Content {
        this.contentRepository.save(Content.new(type, title, description))
        throw RuntimeException("RuntimeException after save")
    }

    fun getContentsOf(type: ContentType): List<Content> {
        return this.contentRepository.findAllByType(type)
    }
}
