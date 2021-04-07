package com.tistory.devs0n.mysqlencoding

import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.Id

@Entity
data class User(
    @Id
    val id: Long,

    @Column
    var name: String,
)
