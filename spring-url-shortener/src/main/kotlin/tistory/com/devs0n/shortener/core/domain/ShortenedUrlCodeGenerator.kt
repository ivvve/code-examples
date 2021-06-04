package tistory.com.devs0n.shortener.core.domain

interface ShortenedUrlCodeGenerator {
    /**
     * @throws CannotGenerateShortenedUrlCodeException
     *         If server cannot generate code of shortened url (e.g. There's no unassigned code)
     */
    suspend fun generate(): String
}
