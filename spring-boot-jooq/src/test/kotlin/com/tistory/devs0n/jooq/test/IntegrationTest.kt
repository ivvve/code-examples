package com.tistory.devs0n.jooq.test

import com.tistory.devs0n.jooq.SpringBootJooqApplication
import io.kotest.extensions.spring.SpringExtension
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.ActiveProfiles
import org.springframework.test.context.DynamicPropertyRegistry
import org.springframework.test.context.DynamicPropertySource
import org.testcontainers.containers.MySQLContainer

@SpringBootTest(classes = [SpringBootJooqApplication::class])
@ActiveProfiles("test")
interface IntegrationTest {
    companion object {
        val kotestExtensions = listOf(
            SpringExtension, // Integrate Spring with Kotest (see https://kotest.io/docs/extensions/spring.html)
        )

        private val mysqlContainer = MySQLContainer<Nothing>("mysql:8.0").apply {
            withDatabaseName("playground")
            withUsername("root")
            withPassword("root")
            withEnv("TZ", "Asia/Seoul")
            withCommand("mysqld", "--character-set-server=utf8mb4")
            withReuse(true) // to speed up container startup, see https://www.testcontainers.org/features/reuse/
            start()
        }


        @DynamicPropertySource
        @JvmStatic
        fun registerProperties(registry: DynamicPropertyRegistry) {
            setSpringDataJpaProperties(registry)
        }

        private fun setSpringDataJpaProperties(registry: DynamicPropertyRegistry) {
            registry.add("spring.datasource.url") { mysqlContainer.jdbcUrl + "?useSSL=false" }
            registry.add("spring.datasource.username") { mysqlContainer.username }
            registry.add("spring.datasource.password") { mysqlContainer.password }
        }
    }
}
