package com.tistory.devs0n.polling

import com.tistory.devs0n.polling.event.publisher.Event
import com.tistory.devs0n.polling.event.publisher.EventRepository
import com.tistory.devs0n.polling.event.publisher.EventStatus
import io.github.oshai.kotlinlogging.KotlinLogging
import org.redisson.api.RedissonClient
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.Configuration
import org.springframework.kafka.core.KafkaTemplate
import org.springframework.scheduling.annotation.EnableScheduling
import org.springframework.scheduling.annotation.Scheduled
import java.util.concurrent.CompletableFuture
import java.util.concurrent.TimeUnit

@SpringBootApplication
class PollingApplication

fun main(args: Array<String>) {
    runApplication<PollingApplication>(*args)
}
