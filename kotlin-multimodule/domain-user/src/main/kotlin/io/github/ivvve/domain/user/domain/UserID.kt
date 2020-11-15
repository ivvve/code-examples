package io.github.ivvve.domain.user.domain

import org.springframework.data.annotation.Id
import java.util.*

class UserID {
    @Id
    private val id: UUID

    constructor() {
        this.id = UUID.randomUUID()
    }

    private constructor(rawId: String) {
        this.id = UUID.fromString(rawId)
    }

    companion object {
        fun of(rawId: String): UserID {
            return UserID(rawId)
        }
    }

    fun getRawId(): String {
        return this.id.toString()
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as UserID

        if (id != other.id) return false

        return true
    }

    override fun hashCode(): Int {
        return id.hashCode()
    }
}