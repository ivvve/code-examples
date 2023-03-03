package com.tistory.devs0n.sample.integration

import io.kotest.core.config.AbstractProjectConfig
import io.kotest.core.extensions.Extension
import io.kotest.extensions.spring.SpringExtension
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.ActiveProfiles

@ActiveProfiles("test")
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@Target(AnnotationTarget.CLASS)
@Retention(AnnotationRetention.RUNTIME)
annotation class IntegrationTest

/**
 * 통합 테스트를 위한 Kotest 설정
 */
object ProjectConfig : AbstractProjectConfig() {

    override fun extensions(): List<Extension> {
        return listOf(
            SpringExtension, // Kotest-Spring 통합 설정
            MySQLTestcontainersListener(),
            MongodbIntegrationListener(),
            RedisTestcontainersListener(),
        )
    }
}
