package com.tistory.devs0n.springmongo

import com.tistory.devs0n.springmongo.content.domain.ContentRepository
import com.tistory.devs0n.springmongo.content.domain.ContentType
import com.tistory.devs0n.springmongo.content.service.ContentService
import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatThrownBy
import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.DynamicPropertyRegistry
import org.springframework.test.context.DynamicPropertySource
import org.testcontainers.containers.MongoDBContainer

@SpringBootTest
class SpringMongoApplicationTests {
    companion object {
        private val mongodbContainer = MongoDBContainer("mongo:4.4").apply {
            this.start()
        }

        @JvmStatic
        @DynamicPropertySource
        fun registerProperties(registry: DynamicPropertyRegistry) {
            registry.add("spring.data.mongodb.uri", mongodbContainer::getReplicaSetUrl)
        }
    }

    @Test
    fun contextLoads() {
    }

    @Autowired
    lateinit var contentService: ContentService

    @Autowired
    lateinit var contentRepository: ContentRepository

    @Test
    fun `createContent - Content 저장`() {
        // when
        contentService.createContent(
            type = ContentType.NOVEL,
            title = "Novel 1",
            description = "This is a novel content"
        )

        // then
        val contents = contentRepository.findAll()

        assertThat(contents).hasSize(1)
        assertThat(contents[0].type).isEqualTo(ContentType.NOVEL)
        assertThat(contents[0].information.title).isEqualTo("Novel 1")
        assertThat(contents[0].information.description).isEqualTo("This is a novel content")
    }

    @Test
    fun `createContent - Content 저장 후 Exception 발생 시 저장되지 않는다`() {
        // when
        assertThatThrownBy {
            contentService.createContent(
                type = ContentType.NOVEL,
                title = "Novel 1",
                description = "This is a novel content",
                throws = true
            )
        }.isInstanceOf(RuntimeException::class.java)

        // then
        val contents = contentRepository.findAll()

        assertThat(contents).hasSize(0)
    }

    @AfterEach
    fun tearDown() {
        contentRepository.deleteAll()
    }
}
