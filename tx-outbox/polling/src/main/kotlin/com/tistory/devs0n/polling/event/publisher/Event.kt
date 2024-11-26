package com.tistory.devs0n.polling.event.publisher

import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import org.springframework.data.annotation.CreatedDate
import org.springframework.data.annotation.Id
import org.springframework.data.relational.core.mapping.Column
import org.springframework.data.relational.core.mapping.Table
import java.time.LocalDateTime

@Table(name = "events")
class Event {
    @Id
    var id: Long? = null
        private set

    @Column(value = "status")
    var status: EventStatus
        private set

    @Column(value = "partition_key")
    val partitionKey: String

    @Column(value = "topic")
    val topic: String

    @Column(value = "payload")
    val payload: String// actual column type is JSON

    @CreatedDate
    @Column(value = "created_at")
    var createAt: LocalDateTime = LocalDateTime.now()
        private set // to prevent JDBC data mapping error

    constructor(partitionKey: String, topic: String, payload: Any) {
        this.status = EventStatus.WAITING
        this.partitionKey = partitionKey
        this.topic = topic
        this.payload = when (payload) {
            is String -> payload
            else -> payloadObjectMapper.writeValueAsString(payload)
        }
    }

    fun publish() {
        this.status = EventStatus.PUBLISHED
    }

    companion object {
        private val payloadObjectMapper = jacksonObjectMapper()
    }
}
