package com.tistory.devs0n.decorator.lecture

class Client(
    private val commentService: CommentService
) {
    fun addComment(comment: String) {
        this.commentService.addComment(comment)
    }
}
