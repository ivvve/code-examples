package tistory.com.devs0n.shortener.core.domain

import org.springframework.data.annotation.Id
import org.springframework.data.relational.core.mapping.Column
import org.springframework.data.relational.core.mapping.Table
import java.time.LocalDateTime

@Table(value = "shortened_urls")
data class ShortenedUrl(
    @Column(value = "original")
    val original: String,

    @Column(value = "code")
    val code: String,
) {
    @Column(value = "created_at")
    var createdAt: LocalDateTime = LocalDateTime.now()
        private set // to r2jdbc set property

    @Id
    @Column(value = "id")
    var id: Long? = null
        private set // to r2jdbc set property

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
