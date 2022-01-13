package com.tistory.devs0n.servicelayertest.domain

import javax.persistence.*

@Entity
class Member {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null

    @Column(name = "name")
    var name: String
        private set

    constructor(name: String) {
        this.name = name
    }

    fun changeName(nameToChange: String) {
        this.name = nameToChange
    }
}
