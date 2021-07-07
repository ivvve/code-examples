package com.tistory.devs0n.restdocs.documentation

import com.tistory.devs0n.restdocs.RestDocsExampleApplicationTests
import io.restassured.RestAssured
import io.restassured.builder.RequestSpecBuilder
import io.restassured.specification.RequestSpecification
import org.assertj.core.api.Assertions
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.springframework.http.HttpStatus
import org.springframework.restdocs.RestDocumentationContextProvider
import org.springframework.restdocs.RestDocumentationExtension
import org.springframework.restdocs.payload.PayloadDocumentation
import org.springframework.restdocs.restassured3.RestAssuredRestDocumentation

@ExtendWith(RestDocumentationExtension::class)
class UserDocumentationTest : RestDocsExampleApplicationTests() {
    private lateinit var spec: RequestSpecification

    @BeforeEach
    fun setUp(restDocumentation: RestDocumentationContextProvider) {
        this.spec = RequestSpecBuilder()
            .addFilter(RestAssuredRestDocumentation.documentationConfiguration(restDocumentation))
            .build()
    }
    @Test
    fun getUserApi() {
        // when
        val response = RestAssured
            .given(this.spec).log().all().filter(
                RestAssuredRestDocumentation.document(
                    "user", PayloadDocumentation.responseFields(
                        PayloadDocumentation.fieldWithPath("name").description("이름"),
                        PayloadDocumentation.fieldWithPath("address").description("사용자 주소"),
                    )
                )
            )
            .`when`().get("/users")
            .then().log().all().extract()

        // then
        Assertions.assertThat(response.statusCode()).isEqualTo(HttpStatus.OK.value())
    }
}