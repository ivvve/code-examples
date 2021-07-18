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
        private set

    @Column("user_id")
    var userId: String
        private set

    @Column("email")
    var email: String
        private set

    @Column("name")
    var name: String
        private set

    @Column("encrypted_password")
    var encryptedPassword: String
        private set

    constructor(email: String, name: String, encryptedPassword: String) {
        this.userId = UUID.randomUUID().toString()
        this.email = email
        this.name = name
        this.encryptedPassword = encryptedPassword
    }
}
