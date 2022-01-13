package com.tistory.devs0n.rw.core.member

import java.util.*

data class MemberId(
    val id: String = UUID.randomUUID().toString()
)
