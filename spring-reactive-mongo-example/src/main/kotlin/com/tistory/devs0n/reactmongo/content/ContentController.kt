package com.tistory.devs0n.reactmongo.content

import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/contents")
class ContentController(
    private val contentService: ContentService
) {
    @GetMapping("/{id}")
    suspend fun getContent(@PathVariable("id") id: String): Content = this.contentService.getContent(id)

    @GetMapping
    suspend fun getContentsOfType(@RequestParam("type") type: String): List<Content> =
        this.contentService.getContentsOf(ContentType.valueOf(type))

    @PostMapping
    suspend fun createContent(@RequestBody request: Map<String, String>): Content {
        val type = request["type"]?.let { ContentType.valueOf(it) }
            ?: throw IllegalArgumentException("`type` parameter not found")
        val title = request["title"] ?: throw IllegalArgumentException("`title` parameter not found")
        val description = request["desc"] ?: throw IllegalArgumentException("`desc` parameter not found")


        if (request["throws"]?.toBoolean() == true) {
            return this.contentService.createContentAndThrow(type, title, description)
        }

        return this.contentService.createContent(type, title, description)
    }

    @DeleteMapping("/{id}")
    suspend fun deleteContent(@PathVariable("id") id: String): Unit = this.contentService.deleteContent(id)
}
