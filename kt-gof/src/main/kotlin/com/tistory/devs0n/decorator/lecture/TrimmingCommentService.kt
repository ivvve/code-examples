package com.tistory.devs0n.decorator.lecture

// Concrete Decorator
class TrimmingCommentService(
    commentService: CommentService
) : CommentDecorator(commentService) {
    override fun addComment(comment: String) {
        super.addComment(this.trim(comment))
    }

    private fun trim(comment: String) = comment.replace("...", "")
}
