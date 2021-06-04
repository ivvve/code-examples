package tistory.com.devs0n.shortener.acceptance.step

import io.restassured.RestAssured
import io.restassured.http.ContentType
import io.restassured.response.ExtractableResponse
import io.restassured.response.Response
import org.assertj.core.api.Assertions.assertThat
import org.springframework.http.HttpStatus
import java.net.URL

private const val SHORTEN_URL_URL = "/shorten-url"

// given
fun `Sent Shorten URL Request`(originalUrl: String): ExtractableResponse<Response> {
    return `Send Shorten URL Request`(originalUrl)
}

// when
fun `Send Shorten URL Request`(originalUrl: String?): ExtractableResponse<Response> {
    val requestBody = mapOf("url" to originalUrl)

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

fun `Shortened URL Responded`(shortenUrlResponse: ExtractableResponse<Response>, originalUrl: String) {
    val responseOriginalUrl = getOriginalUrlFrom(shortenUrlResponse)
    val responseShortenedUrl = getShortenedUrlFrom(shortenUrlResponse)

    assertThat(responseOriginalUrl).isEqualTo(originalUrl)
    assertThat(responseShortenedUrl).isNotEqualTo(responseOriginalUrl)
}

fun `Shorten URL Request Failed - Cannot Generate Shortened URL Code`(shortenUrlResponse: ExtractableResponse<Response>) {
    assertThat(shortenUrlResponse.statusCode()).isEqualTo(HttpStatus.SERVICE_UNAVAILABLE.value())
}

fun `Redirect Shortened URL Request Failed - Invalid url`(
    shortenUrlResponse: ExtractableResponse<Response>
) {
    assertThat(shortenUrlResponse.statusCode()).isEqualTo(HttpStatus.BAD_REQUEST.value())
}


fun getOriginalUrlFrom(shortenUrlResponse: ExtractableResponse<Response>): String {
    return shortenUrlResponse.body().jsonPath().getString("original")
}

fun getShortenedUrlFrom(shortenUrlResponse: ExtractableResponse<Response>): String {
    return shortenUrlResponse.body().jsonPath().getString("shortened")
}

fun getShortenedUrlCodeFrom(shortenUrlResponse: ExtractableResponse<Response>): String {
    return URL(getShortenedUrlFrom(shortenUrlResponse)).path.substring(1) // remove first `/`
}
