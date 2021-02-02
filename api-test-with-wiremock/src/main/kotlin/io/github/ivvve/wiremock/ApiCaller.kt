package io.github.ivvve.wiremock

import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Component
import java.net.URI
import java.net.http.HttpClient
import java.net.http.HttpRequest
import java.net.http.HttpResponse
import java.time.Duration

@Component
class ApiCaller(
    @Value("\$some-api.host") private val apiHost: String,
    @Value("\$some-api.port") private val apiPort: Int
) {
    private val httpClient = HttpClient.newBuilder()
        .version(HttpClient.Version.HTTP_1_1)
        .connectTimeout(Duration.ofSeconds(2))
        .build()

    fun call(keyword: String): String {
        val request = HttpRequest.newBuilder()
            .GET()
            .uri(URI.create("$apiHost:$apiPort?keyword=$keyword"))
            .setHeader("Content-Type", "application/json")
            .build()

        return this.httpClient.send(request, HttpResponse.BodyHandlers.ofString()).body()
    }
}