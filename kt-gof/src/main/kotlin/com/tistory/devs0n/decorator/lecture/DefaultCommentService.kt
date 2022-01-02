package com.tistory.devs0n.decorator.lecture

// Concrete Component
class DefaultCommentService : CommentService {
    override fun addComment(comment: String) {
        println(comment)
    }
}
