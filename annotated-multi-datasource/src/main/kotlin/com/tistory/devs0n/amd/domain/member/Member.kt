package com.tistory.devs0n.amd.domain.member

import java.time.LocalDate
import javax.persistence.*

@Entity
@Table(
    name = "member",
    indexes = [
        Index(name = "name_index", columnList = "name")
    ]
)
class Member(
    @Column(name = "name")
    val name: String,

    @Column(name = "birth_date")
    val date: LocalDate
) {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null
}
