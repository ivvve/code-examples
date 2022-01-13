package com.tistory.devs0n.eventtx.config.web

import org.springframework.boot.autoconfigure.data.jpa.JpaRepositoriesAutoConfiguration
import org.springframework.web.bind.annotation.RestControllerAdvice

@RestControllerAdvice
class WebExceptionHandler {

}

fun main() {
    JpaRepositoriesAutoConfiguration
}
