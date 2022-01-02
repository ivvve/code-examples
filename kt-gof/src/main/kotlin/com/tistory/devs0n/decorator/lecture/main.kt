package com.tistory.devs0n.decorator.lecture

fun main() {
    val enableSpamFiltering = true
    val enableTrimming = true

    var commentService: CommentService = DefaultCommentService()

    if (enableSpamFiltering) {
        commentService = SpamFilteringCommentService(commentService)
    }

    if (enableTrimming) {
        commentService = TrimmingCommentService(commentService)
    }

    val client = Client(commentService)
    client.addComment("Hello, World")
    client.addComment("흐음...")
    client.addComment("https://google.com")
}
