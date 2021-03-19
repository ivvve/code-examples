package io.github.ivvve.multids.second

import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id

@Entity
class SecondEntity(
    @Id
    @GeneratedValue
    val id: Long,

    @Column
    val name: String,

    @Column
    val second: String,
)
