package com.tistory.devs0n.cdc.event.publisher

import org.springframework.data.repository.CrudRepository

interface EventRepository : CrudRepository<Event, Long>
