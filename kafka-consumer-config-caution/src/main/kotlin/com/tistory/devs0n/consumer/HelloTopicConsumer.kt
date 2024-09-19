package com.tistory.devs0n.consumer

import org.apache.kafka.clients.consumer.ConsumerRecord
import org.springframework.kafka.annotation.KafkaListener
import org.springframework.kafka.core.KafkaTemplate
import org.springframework.stereotype.Component

@Component
class HelloTopicConsumer(
    private val kafkaTemplate: KafkaTemplate<String, String>
) {

    @KafkaListener(groupId = "spring-server", topics = ["hello_topic"])
    fun consume(record: ConsumerRecord<String, String>) {
        this.kafkaTemplate.setConsumerFactory()

        println("--")
//        println("record count: ${records.count()}")
//        records.forEach { println(it) }
        Thread.sleep(2_000)
        println(record)
        println("--")
    }
}
