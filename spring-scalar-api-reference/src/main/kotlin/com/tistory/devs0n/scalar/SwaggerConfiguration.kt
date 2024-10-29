package com.tistory.devs0n.scalar

import io.swagger.v3.oas.models.Components
import io.swagger.v3.oas.models.OpenAPI
import io.swagger.v3.oas.models.info.Info
import io.swagger.v3.oas.models.security.SecurityRequirement
import io.swagger.v3.oas.models.security.SecurityScheme
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class SwaggerConfiguration {
    @Bean
    fun openApi(): OpenAPI {
        return OpenAPI()
            .info(Info().title("Scalar API Reference example API"))
            .components(
                Components().addSecuritySchemes(
                    "Bearer Token",
                    SecurityScheme()
                        .type(SecurityScheme.Type.HTTP)
                        .`in`(SecurityScheme.In.HEADER)
                        .name("Authorization")
                        .scheme("bearer")
                        .bearerFormat("JWT")

                )
            )
            .addSecurityItem(
                SecurityRequirement()
                    .addList("Bearer Token")
            )
    }
}
