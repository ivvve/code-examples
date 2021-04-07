package com.tistory.devs0n.mysqlencoding

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.DynamicPropertyRegistry
import org.springframework.test.context.DynamicPropertySource
import org.testcontainers.containers.MySQLContainer

@SpringBootTest
class MysqlencodingApplicationTests {
    companion object {
        private val mysqlContainer = MySQLContainer<Nothing>("mysql:5.7").apply {
            start()
        }

        @JvmStatic
        @DynamicPropertySource
        fun registerDbProperties(properties: DynamicPropertyRegistry) {
            properties.add("spring.datasource.url", mysqlContainer::getJdbcUrl)
            properties.add("spring.datasource.username", mysqlContainer::getUsername)
            properties.add("spring.datasource.password", mysqlContainer::getPassword)
        }
    }

    @Autowired
    lateinit var userRepository: UserRepository

    @Test
    @DisplayName("한국어 저장 테스트")
    fun koreanTest() {
        userRepository.saveAll(
            listOf(
                User(1L, "Chris"),
                User(2L, "손한국")
            )
        )

        assertThat(userRepository.findById(1L).get().name).isEqualTo("Chris")
        assertThat(userRepository.findById(2L).get().name).isEqualTo("손한국")
    }
}
