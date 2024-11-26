package com.tistory.devs0n.polling.event.publisher

import org.springframework.data.jdbc.repository.query.Query
import org.springframework.data.repository.CrudRepository
import org.springframework.data.repository.query.Param

interface EventRepository : CrudRepository<Event, Long> {

    @Query("SELECT * FROM events WHERE status = :status ORDER BY id LIMIT :fetchSize")
    fun findAllByStatusOrderByOldest(@Param("status") status: EventStatus, fetchSize: Int): List<Event>
}
