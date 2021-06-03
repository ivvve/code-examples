package tistory.com.devs0n.shortener.core.domain

import org.springframework.data.annotation.Id
import org.springframework.data.relational.core.mapping.Column
import org.springframework.data.relational.core.mapping.Table
import java.time.LocalDateTime

@Table(value = "shortened_urls")
class ShortenedUrl {
    @Id
    @Column(value = "id")
    var id: Long? = null
        protected set // to r2jdbc set property

    @Column(value = "original")
    val original: String

    @Column(value = "code")
    val code: String

    @Column(value = "created_at")
    var createdAt: LocalDateTime
        protected set // to r2jdbc set property

    constructor(original: String, code: String) {
        this.original = original
        this.code = code
        this.createdAt = LocalDateTime.now()
    }

    fun getFullShortenedUrl(host: String): String {
        return host + "/" + this.code
    }

    companion object {
        val CODE_CHARACTERS = HashSet<Char>().apply {
            addAll("abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789".toList())
        }

        const val CODE_LENGTH = 7
    }
}
