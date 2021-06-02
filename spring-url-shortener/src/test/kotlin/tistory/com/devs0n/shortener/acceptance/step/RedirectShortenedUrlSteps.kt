package tistory.com.devs0n.shortener.acceptance.step

import io.restassured.RestAssured
import io.restassured.response.ExtractableResponse
import io.restassured.response.Response
import org.assertj.core.api.Assertions.assertThat
import org.springframework.http.HttpStatus

// when
fun `Send Redirect Shortened URL Request`(
    shortenUrlResponse: ExtractableResponse<Response>
): ExtractableResponse<Response> {
    val shortenedUrlCode = getShortenedUrlCodeFrom(shortenUrlResponse)
    return `Send Redirect Shortened URL Request`(shortenedUrlCode)
}

fun `Send Redirect Shortened URL Request`(shortenedUrlCode: String): ExtractableResponse<Response> {
    return RestAssured
        .given().log().all()
        .`when`().get("/$shortenedUrlCode")
        .then().log().all()
        .extract()
}

fun `Redirect Shortened URL Request Succeeded`(redirectShortenedUrlResponse: ExtractableResponse<Response>) {
    assertThat(redirectShortenedUrlResponse.statusCode()).isEqualTo(HttpStatus.FOUND)
}

fun `Redirect to Raw URL Responded`(redirectShortenedUrlResponse: ExtractableResponse<Response>, rawUrl: String) {
    assertThat(redirectShortenedUrlResponse.header("Location")).isEqualTo(rawUrl)
}
