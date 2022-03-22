package com.tistory.devs0n.dgs.publisher

import org.slf4j.LoggerFactory
import org.springframework.stereotype.Repository

@Repository
class PublisherRepository {
    private val logger = LoggerFactory.getLogger(this::class.java)

    private val publishers: MutableMap<Long, Publisher> = mutableMapOf()

    fun save(publisher: Publisher): Publisher {
        this.publishers[publisher.id] = publisher
        return publisher
    }

    fun findAll(): List<Publisher> = this.publishers.values.toList()

    fun findAllByIds(publisherIds: Collection<Long>): List<Publisher> {
        logger.info("[PublisherRepository.findAllByIds] publisherIds - $publisherIds")
        return publisherIds.mapNotNull { id -> this.publishers[id] }
    }

    fun findById(publisherId: Long): Publisher? {
        logger.info("[PublisherRepository.findById] publisherId - $publisherId")
        return this.publishers[publisherId]
    }
}
