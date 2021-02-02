package io.github.ivvve.wiremock


import com.github.tomakehurst.wiremock.WireMockServer
import org.hamcrest.Matchers.equalTo
import org.junit.jupiter.api.BeforeAll
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.options
import org.springframework.test.web.servlet.result.MockMvcResultHandlers.print
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.content
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.status


@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
class WiremockApplicationTests {
    @Autowired
    lateinit var mockMvc: MockMvc
    lateinit var wireMockServer: WireMockServer

    @Test
    fun contextLoads() {
    }

    @BeforeAll
    fun setUp() {
        wireMockServer = WireMockServer(9000)
    }

    @Test
    fun `API 정상 응답`() {
        this.mockMvc
            .perform(get("/").queryParam("keyword", "devson"))
            .andDo(print())
            .andExpect(status().isOk)
            .andExpect(content().string(equalTo("Hello, World")));
    }

    @Test
    fun `API 오류 응답`() {
        this.mockMvc
            .perform(get("/").queryParam("keyword", "devson"))
            .andDo(print())
            .andExpect(status().isOk)
            .andExpect(content().string(equalTo("Oops")));
    }
}
