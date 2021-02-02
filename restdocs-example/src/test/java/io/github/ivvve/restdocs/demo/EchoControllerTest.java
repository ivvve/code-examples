package io.github.ivvve.restdocs.demo;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.restdocs.AutoConfigureRestDocs;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;

import static org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.document;
import static org.springframework.restdocs.mockmvc.RestDocumentationRequestBuilders.get;
import static org.springframework.restdocs.request.RequestDocumentation.parameterWithName;
import static org.springframework.restdocs.request.RequestDocumentation.requestParameters;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(EchoController.class)
@AutoConfigureRestDocs
class EchoControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @Test
    @DisplayName("")
    void echo() throws Exception {
        // given
        final String value = "Chris";

        // when & then
        final MockHttpServletRequestBuilder request = get("/echo").queryParam("value", value);
        mockMvc.perform(request)
                .andExpect(status().isOk())
                .andExpect(content().string(value))
                .andDo(document("echo", requestParameters(parameterWithName("value").description("echo target"))));
    }
}
