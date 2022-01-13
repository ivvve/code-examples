package com.tistory.devs0n.eventtx.common.event

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty
import org.springframework.context.annotation.Configuration

@Configuration
@ConditionalOnProperty(name = ["config.event.mode"], havingValue = "kafka")
class KafkaDomainEventPublisher {
}
