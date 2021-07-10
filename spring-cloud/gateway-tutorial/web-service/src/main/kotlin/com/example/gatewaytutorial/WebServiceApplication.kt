package com.example.gatewaytutorial

import org.springframework.beans.factory.annotation.Value
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestHeader
import org.springframework.web.bind.annotation.RestController

@SpringBootApplication
@RestController
class WebServiceApplication(
    @Value("\${spring.application.name}") private val serviceName: String
) {
    @GetMapping("/welcome")
    fun welcome(@RequestHeader("service-request") serviceRequestHeader: String? = null): String {
        return "Welcome ${this.serviceName} - header: $serviceRequestHeader"
    }
}

fun main(args: Array<String>) {
    runApplication<WebServiceApplication>(*args)
}
