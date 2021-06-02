package tistory.com.devs0n.shortener.acceptance.step

import io.restassured.RestAssured
import io.restassured.http.ContentType
import io.restassured.response.ExtractableResponse
import io.restassured.response.Response
import org.assertj.core.api.Assertions.assertThat
import org.springframework.http.HttpStatus
import java.net.URI

private const val SHORTEN_URL_URL = "/shorten-url"

// when
fun `Send Shorten URL Request`(rawUrl: String): ExtractableResponse<Response> {
    val requestBody = mapOf("url" to rawUrl)

    return RestAssured
        .given().log().all()
        .`when`().contentType(ContentType.JSON).body(requestBody).post(SHORTEN_URL_URL)
        .then().log().all()
        .extract()
}

// then
fun `Shorten URL Request Succeeded`(shortenUrlResponse: ExtractableResponse<Response>) {
    assertThat(shortenUrlResponse.statusCode()).isEqualTo(HttpStatus.CREATED.value())
}

fun `Shortened URL Responded`(shortenUrlResponse: ExtractableResponse<Response>, rawUrl: String) {
    val shortenedUrl = getShortenedUrl(shortenUrlResponse)
    val shortenedUrlId = getShortenedUrlId(shortenUrlResponse)

    assertThat(shortenedUrl).isNotEqualTo(rawUrl)
    assertThat(shortenedUrlId).hasSize(7)
    assertThat(shortenedUrlId.any { !it.isLetterOrDigit() }).isFalse
    assertThat(
        URI(shortenedUrl).path.substring(1) // remove first `/` from path
    ).isEqualTo(shortenedUrlId)
}

fun getShortenedUrl(shortenUrlResponse: ExtractableResponse<Response>): String {
    return shortenUrlResponse.body().jsonPath().getString("url")
}

fun getShortenedUrlId(shortenUrlResponse: ExtractableResponse<Response>): String {
    return shortenUrlResponse.body().jsonPath().getString("id")
}
