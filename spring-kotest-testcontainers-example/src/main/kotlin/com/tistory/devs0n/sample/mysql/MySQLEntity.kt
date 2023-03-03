package com.tistory.devs0n.sample.mysql

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id

@Entity
class MySQLEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0

    val name: String

    constructor(name: String) {
        this.name = name
    }

    override fun toString(): String {
        return "MySQLEntity(id=$id, name='$name')"
    }
}
