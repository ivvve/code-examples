package com.tistory.devs0n.decorator.lecture

// Concrete Decorator
class SpamFilteringCommentService(
    commentService: CommentService
) : CommentDecorator(commentService) {
    override fun addComment(comment: String) {
        if (!this.isSpam(comment)) {
            super.addComment(comment)
        }
    }

    private fun isSpam(comment: String): Boolean = comment.contains("http")
}
