package com.tistory.devs0n.eventtx.common.event

import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean

@ConditionalOnMissingBean(KafkaDomainEventPublisher::class)
class ConsoleDomainEventPublisher {
}
