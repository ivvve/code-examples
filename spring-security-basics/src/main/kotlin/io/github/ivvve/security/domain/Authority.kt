package io.github.ivvve.security.domain

import javax.persistence.*

@Entity(name = "authorities")
class Authority(name: String) {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    var id: Long? = null

    @Column
    var name: String = name
}