package io.github.ivvve.restdocs

import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.restdocs.AutoConfigureRestDocs
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest
import org.springframework.restdocs.JUnitRestDocumentation
import org.springframework.restdocs.mockmvc.MockMvcRestDocumentation
import org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.document
import org.springframework.restdocs.mockmvc.RestDocumentationRequestBuilders.get
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.content
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.status

@WebMvcTest
@AutoConfigureRestDocs
class EchoApiTests {
    @Autowired private lateinit var mockMvc: MockMvc

    @Test
    fun `echo API`() {
        // given
        val value = "Chris"

        // when & then
        val request = get("/echo").queryParam("value", value)
        mockMvc.perform(request)
                .andExpect(status().isOk)
                .andExpect(content().string(value))
                .andDo(document("echo"))
    }
}