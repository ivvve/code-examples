package io.github.ivvve.multids.first

import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id

@Entity
class FirstEntity (
    @Id
    @GeneratedValue
    val id: Long,

    @Column
    val name: String,

    @Column
    val first: String,
)
