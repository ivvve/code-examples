package io.github.ivvve.wiremock

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@SpringBootApplication
@RestController
class WiremockApplication(
    private val apiCaller: ApiCaller
) {
    @GetMapping("/call-api")
    fun callApi(@RequestParam keyword: String): String {
        return this.apiCaller.call(keyword)
    }
}


fun main(args: Array<String>) {
    runApplication<WiremockApplication>(*args)
}
