package com.tistory.devs0n.kafka

import org.apache.kafka.clients.consumer.ConsumerRecord
import org.slf4j.LoggerFactory
import org.springframework.kafka.annotation.KafkaListener
import org.springframework.stereotype.Component

@Component
class SomeTopicListener {
    private val logger = LoggerFactory.getLogger(this::class.java)

    @KafkaListener(topics = ["foo"])
    fun consume(record: ConsumerRecord<String, String>) {
        println("--------")
        this.logger.info("header: ${record.headers()}")
        this.logger.info("partition: ${record.partition()}")
        this.logger.info("offset: ${record.offset()}")
        this.logger.info("key: ${record.key()}")
        this.logger.info("value: ${record.value()}")
        println("--------")
    }
}
