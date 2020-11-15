package io.github.ivvve.domain.user.domain

import org.springframework.data.annotation.CreatedDate
import org.springframework.data.annotation.Id
import org.springframework.data.annotation.LastModifiedDate
import org.springframework.data.relational.core.mapping.Column
import org.springframework.data.relational.core.mapping.Table
import java.time.LocalDateTime

@Table("user")
class User(
        @Column("login_id")
        private val loginId: String,

        @Column("password")
        private var password: String,

        @Column("email")
        private var email: String,

        @Column("displayName")
        private var displayName: String
) {
    @Id
    @Column("id")
    private val id = UserID()

    private var isActive = false

    @Column("created_at")
    @CreatedDate
    private var createdAt = LocalDateTime.now()

    @Column("updated_at")
    @LastModifiedDate
    private var updatedAt: LocalDateTime = LocalDateTime.now()

    fun changeInfo(newEmail: String, newDisplayName: String) {
        this.email = newEmail
        this.displayName = newDisplayName
    }

    // property getters
    fun getRawId(): String = this.id.getRawId()
    fun getId(): UserID = this.id
    fun getEmail(): String = this.email
    fun getDisplayName(): String = this.displayName

    // equals & hashCode
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as User

        if (id != other.id) return false

        return true
    }

    override fun hashCode(): Int {
        return id.hashCode()
    }
}