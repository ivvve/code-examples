package io.github.ivvve.security.domain

import javax.persistence.*

@Entity(name = "customers")
class Customer(email: String, pwd: String, role: String) {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    var id: Long? = null

    @Column
    var email: String = email

    @Column
    var pwd: String = pwd

    @Column
    var role: String = role
}