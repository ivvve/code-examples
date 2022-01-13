package com.tistory.devs0n.springkotest

import io.kotest.core.listeners.TestListener
import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.core.test.TestCase
import io.kotest.spring.SpringListener
import io.restassured.RestAssured
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class EchoAcceptanceTest : BehaviorSpec() {
    override fun listeners(): List<TestListener> {
        return listOf(SpringListener)
    }

    init {


        given("b") {
            `when`("c") {
                and("d") {
                    then("e") {
                        RestAssured

                        println("Hello World!")
                    }
                }
            }
        }
    }
}
