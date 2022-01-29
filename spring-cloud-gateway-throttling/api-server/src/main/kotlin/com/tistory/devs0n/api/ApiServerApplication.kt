package com.tistory.devs0n.api

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController
import javax.servlet.http.HttpServletRequest

@SpringBootApplication
@RestController
class ApiServerApplication {
    @GetMapping("**")
    fun root(request: HttpServletRequest): Map<String, Any> {
        val userId = request.getHeader("X-USER-ID")

        println("Request from '${userId}' came in!")

        return mapOf(
            "success" to true,
            "message" to "Hello $userId",
        )
    }
}

fun main(args: Array<String>) {
    runApplication<ApiServerApplication>(*args)
}
