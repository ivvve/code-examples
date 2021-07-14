package com.tistory.devs0n.user.domain

import org.springframework.data.annotation.Id
import org.springframework.data.relational.core.mapping.Column
import org.springframework.data.relational.core.mapping.Table
import java.util.*

@Table("users")
class User {
    @Id
    @Column("id")
    var id: Long? = null

    @Column("user_id")
    val userId: String

    @Column("email")
    val email: String

    @Column("name")
    val name: String

    @Column("encrypted_password")
    val encryptedPassword: String

    constructor(email: String, name: String, encryptedPassword: String) {
        this.userId = UUID.randomUUID().toString()
        this.email = email
        this.name = name
        this.encryptedPassword = encryptedPassword
    }
}
