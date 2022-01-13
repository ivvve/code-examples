package com.tistory.devs0n.rw.core.member

import java.time.LocalDateTime

class Member {
    val id: MemberId = MemberId()

    var nickname: String
        private set

    val connectedAt: LocalDateTime = LocalDateTime.now()

    constructor(nickname: String) {
        this.nickname = nickname
    }
}
