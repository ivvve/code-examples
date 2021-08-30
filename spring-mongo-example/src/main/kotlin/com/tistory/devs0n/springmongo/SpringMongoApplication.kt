package com.tistory.devs0n.springmongo

import com.tistory.devs0n.springmongo.content.domain.Content
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

    val contents = listOf(
        contentService.createContent(type = ContentType.NOVEL, title = "Novel 1", description = "first novel"),
        contentService.createContent(type = ContentType.VIDEO, title = "Video 1", description = "first video"),
        contentService.createContent(type = ContentType.VIDEO, title = "Video 2", description = "second video"),
    )

    // ID로 조회
    println(contentRepository.findById(contents[0].id!!).get().informationString())

    contentRepository.findAll()
        .forEach { println(it.informationString()) }

    // clear data
    contentRepository.deleteAll()
}
