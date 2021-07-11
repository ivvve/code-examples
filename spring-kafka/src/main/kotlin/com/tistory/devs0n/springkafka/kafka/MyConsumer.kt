package com.tistory.devs0n.springkafka.kafka

import org.springframework.kafka.annotation.KafkaListener
import org.springframework.stereotype.Component

@Component
class MyConsumer {
    @KafkaListener(topics = ["my_topic"])
    fun helloTopicHandler(message: String){
        println("Kafka message: $message")
    }
}
