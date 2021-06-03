package tistory.com.devs0n.shortener.core.domain

import org.springframework.data.annotation.Id
import org.springframework.data.relational.core.mapping.Column
import org.springframework.data.relational.core.mapping.Table
import java.time.LocalDateTime

@Table(value = "shortened_urls")
class ShortenedUrl {
    @Id
    @Column(value = "id")
    val id: Long? = null

    @Column(value = "original")
    val original: String

    @Column(value = "code")
    val code: String

    @Column(value = "created_at")
    val createdAt: LocalDateTime

    constructor(original: String, redirectCode: String) {
        this.original = original
        this.code = redirectCode
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
