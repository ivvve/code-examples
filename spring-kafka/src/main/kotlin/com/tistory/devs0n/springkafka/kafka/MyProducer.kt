package com.tistory.devs0n.springkafka.kafka

import org.springframework.kafka.core.KafkaTemplate
import org.springframework.stereotype.Component
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import java.time.LocalDateTime

@RestController
class MyProducer(
    private val kafkaTemplate: KafkaTemplate<String, String>
) {
    @GetMapping
    fun produceHelloTopic(@RequestParam("message") message: String) {
        this.kafkaTemplate.send("my_topic", message)
    }
}
