package com.tistory.devs0n.example.entity

import jakarta.persistence.*
import java.time.LocalDateTime

@Entity(name = "products")
data class Product(
    @Column(name = "name")
    val name: String,

    @Column(name = "quantity")
    var quantity: Long,

    @Column(name = "registeredAt")
    val registeredAt: LocalDateTime,

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null
)
