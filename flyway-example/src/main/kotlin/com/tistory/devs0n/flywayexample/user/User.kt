package com.tistory.devs0n.flywayexample.user

import javax.persistence.*

@Entity
@Table(name = "users")
data class User(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long,

    @Column
    val name: String,

    @Column
    val address: String,

    @Column
    val email: String,
)
