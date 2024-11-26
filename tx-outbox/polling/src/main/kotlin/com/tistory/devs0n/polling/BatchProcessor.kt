package com.tistory.devs0n.polling

import com.tistory.devs0n.polling.event.publisher.Event
import com.tistory.devs0n.polling.event.publisher.EventRepository
import com.tistory.devs0n.polling.event.publisher.EventStatus
import io.github.oshai.kotlinlogging.KotlinLogging
import org.redisson.api.RedissonClient
import org.springframework.context.annotation.Configuration
import org.springframework.kafka.core.KafkaTemplate
import org.springframework.scheduling.annotation.EnableScheduling
import org.springframework.scheduling.annotation.Scheduled
import java.util.concurrent.CompletableFuture
import java.util.concurrent.TimeUnit

@Configuration
@EnableScheduling
class BatchProcessor(
    private val redissonClient: RedissonClient,
    private val eventRepository: EventRepository,
    private val kafkaTemplate: KafkaTemplate<String, String>,
) {
    private val logger = KotlinLogging.logger {}

    @Scheduled(fixedDelay = 1_000, timeUnit = TimeUnit.MILLISECONDS)
    fun pollEvents() {
        this.eventPollingLock {
            this.pollAndPublishEvents()
        }
    }

    private fun eventPollingLock(block: () -> Unit) {
        val lock = this.redissonClient.getLock("event-polling-lock")

        val locked = lock.tryLock()

        if (locked.not()) {
            this.logger.error { "Failed to get event polling lock" }
            return
        }

        try {
            block()
        } finally {
            lock.unlock()
        }
    }

    private fun pollAndPublishEvents() {
        val eventsToPublish =
            this.eventRepository.findAllByStatusOrderByOldest(status = EventStatus.WAITING, fetchSize = 50)
        if (eventsToPublish.isEmpty()) {
            return
        }

        val publishSuccessEvents = mutableListOf<Event>()
        val producerSendFutures = eventsToPublish.map {
            this.kafkaTemplate
                .send(it.topic, it.partitionKey, it.payload)
                .whenComplete { _result, ex ->
                    when (ex) {
                        null -> {
                            it.publish()
                            publishSuccessEvents.add(it)
                        }

                        else -> {
                            logger.error(ex) { "Failed to publish message: ($it)" }
                        }
                    }
                }
        }
        CompletableFuture.allOf(*producerSendFutures.toTypedArray()).join()

        this.eventRepository.saveAll(publishSuccessEvents)
        this.logger.info { "${publishSuccessEvents.size} / ${eventsToPublish.size} events have published" }
    }
}
