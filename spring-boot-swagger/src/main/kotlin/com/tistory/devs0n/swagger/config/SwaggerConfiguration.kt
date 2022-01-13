package com.tistory.devs0n.swagger.config

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import springfox.documentation.builders.ApiInfoBuilder
import springfox.documentation.builders.PathSelectors
import springfox.documentation.builders.RequestHandlerSelectors
import springfox.documentation.service.ApiInfo
import springfox.documentation.service.Contact
import springfox.documentation.spi.DocumentationType
import springfox.documentation.spring.web.plugins.Docket

@Configuration
class SwaggerConfiguration {
    @Bean
    fun docket(): Docket = Docket(DocumentationType.OAS_30)
        .useDefaultResponseMessages(false)
        .select()
        .apis(RequestHandlerSelectors.basePackage("com.tistory.devs0n.swagger.web"))
        .paths(PathSelectors.any())
        .build()
        .host("http://devson-dev-server.com")
        .apiInfo(this.apiInfo())

    private fun apiInfo(): ApiInfo = ApiInfoBuilder()
        .title("HTTP API Document")
        .description("API document")
        .contact(Contact("devson", "https://devs0n.tistory.com/", "devson@devson.com"))
        .version("1.0")
        .build()
}
