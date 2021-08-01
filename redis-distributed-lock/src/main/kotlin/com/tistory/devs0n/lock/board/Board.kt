package com.tistory.devs0n.lock.board

import javax.persistence.*

@Entity(name = "boards")
class Board {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null

    @Column(name = "title")
    val title: String

    @Column(name = "hits")
    var hits: Int = 0
        private set

    constructor(title: String) {
        this.title = title
    }

    fun hit() {
        this.hits++
    }
}
