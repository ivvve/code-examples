package com.tistory.devs0n.springmongo

import com.tistory.devs0n.springmongo.content.domain.ContentRepository
import com.tistory.devs0n.springmongo.content.domain.ContentType
import com.tistory.devs0n.springmongo.content.service.ContentService
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class SpringMongoApplication

fun main(args: Array<String>) {
    val ac = runApplication<SpringMongoApplication>(*args)
    val contentService = ac.getBean(ContentService::class.java)
    val contentRepository = ac.getBean(ContentRepository::class.java)

    // clean
    contentRepository.deleteAll()

    // check
    contentService.createContent(ContentType.NOVEL, "Novel 1", "first")
    try {
        contentService.createContentAndThrow(ContentType.NOVEL, "Novel 2", "second")
    } catch (e: Exception) {}
    contentService.getContentsOf(ContentType.NOVEL).forEach{ println("${it.id} - ${it.type} ${it.information.title} ${it.information.description}") }
}
