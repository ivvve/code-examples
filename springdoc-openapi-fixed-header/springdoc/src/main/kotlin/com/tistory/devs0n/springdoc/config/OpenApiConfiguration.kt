package com.tistory.devs0n.springdoc.config

import io.swagger.v3.oas.annotations.enums.SecuritySchemeIn
import io.swagger.v3.oas.annotations.enums.SecuritySchemeType
import io.swagger.v3.oas.annotations.security.SecurityScheme
import io.swagger.v3.oas.models.info.Info
import io.swagger.v3.oas.models.security.SecurityRequirement
import org.springdoc.core.GroupedOpenApi
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

private const val AUTH_TOKEN_HEADER = "X-AUTH-TOKEN"

// add `Authorize` button - https://www.baeldung.com/spring-openapi-global-securityscheme#springdoc-openapi-base-configuration
@SecurityScheme(
    type = SecuritySchemeType.APIKEY, `in` = SecuritySchemeIn.HEADER,
    name = AUTH_TOKEN_HEADER, description = "Auth Token",
)
@Configuration
class OpenApiConfiguration {

    @Bean
    fun api(): GroupedOpenApi {
        return GroupedOpenApi.builder()
            .group("api")
            .addOpenApiCustomiser {
                it
                    .info(
                        Info()
                            .title("API")
                            .description("API Document")
                            .version("1.0")
                    )
                    // enable to send header - https://github.com/swagger-api/swagger-ui/issues/5715#issuecomment-624866240
                    .security(
                        listOf(
                            SecurityRequirement().addList(AUTH_TOKEN_HEADER),
                        )
                    )
            }
            .pathsToMatch("/**")
            .build()
    }
}
