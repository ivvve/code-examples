package com.tistory.devs0n.decorator.lecture

// Decorator
abstract class CommentDecorator(
    protected val commentService: CommentService
) : CommentService {
    override fun addComment(comment: String) {
        this.commentService.addComment(comment)
    }
}
