package tistory.com.devs0n.shortener

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class SpringUrlShortenerApplication

fun main(args: Array<String>) {
    runApplication<SpringUrlShortenerApplication>(*args)
}
