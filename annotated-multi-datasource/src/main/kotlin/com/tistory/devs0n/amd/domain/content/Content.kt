package com.tistory.devs0n.amd.domain.content

import javax.persistence.*

@Entity
@Table(
    name = "contents",
    indexes = [
        Index(name = "order_seq_index", columnList = "order_seq")
    ]
)
class Content(
    @Column(name = "title")
    val title: String,

    @Column(name = "description")
    val description: String,

    @Column(name = "order_seq")
    val order: Int
) {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null
}
