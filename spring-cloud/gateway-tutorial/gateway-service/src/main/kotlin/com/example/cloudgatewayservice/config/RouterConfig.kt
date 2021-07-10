package com.example.cloudgatewayservice.config

import org.springframework.cloud.gateway.route.RouteLocator
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

//@Configuration
class RouterConfig {
    @Bean
    fun gatewayRoutes(builder: RouteLocatorBuilder): RouteLocator {
        return builder.routes()
            .route { r ->
                r.path("/first-service/**")
                    .filters { f ->
                        f.stripPrefix(1)
                            .addRequestHeader("service-request", "first-request-header")  // 요청 header 추가
                            .addResponseHeader("service-response", "first-response-header") // 응답 header 추가
                    }
//                    .uri("http://localhost:8081/")
                    .uri("lb://FIRST-SERVICE")
            }
            .route { r ->
                r.path("/second-service/**")
                    .filters { f ->
                        f.stripPrefix(1)
                            .addRequestHeader("service-request", "second-request-header")  // 요청 header 추가
                            .addResponseHeader("service-response", "second-response-header") // 응답 header 추가
                    }
//                    .uri("http://localhost:8082/")
                    .uri("lb://SECOND-SERVICE")
            }
            .build()
    }
}
