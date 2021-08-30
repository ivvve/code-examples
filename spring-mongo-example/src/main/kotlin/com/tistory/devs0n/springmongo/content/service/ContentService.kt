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
    fun createContent(type: ContentType, title: String, description: String, throws: Boolean = false): Content {
        val content = this.contentRepository.save(Content(type, title, description))
        LOGGER.info("Content($type, $title, $description) created")

        if (throws) {
            throw RuntimeException("RuntimeException after save")
        }

        return content
    }

    companion object {
        private val LOGGER = LoggerFactory.getLogger(this::class.java)
    }
}
