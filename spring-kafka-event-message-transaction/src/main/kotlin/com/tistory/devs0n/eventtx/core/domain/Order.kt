package com.tistory.devs0n.eventtx.core.domain

import org.hibernate.annotations.CreationTimestamp
import org.hibernate.annotations.UpdateTimestamp
import java.time.ZonedDateTime
import javax.persistence.*

@Entity
data class Order(
    @Id
    @Column(name = "id")
    val id: String,

    @Column(name = "user_id")
    val userId: String,

    @ElementCollection(fetch = FetchType.EAGER)
    val orderItems: MutableList<OrderItem>,
) {
    @CreationTimestamp
    val orderedAt: ZonedDateTime = ZonedDateTime.now()

    @UpdateTimestamp
    val updatedAt: ZonedDateTime = ZonedDateTime.now()
}
