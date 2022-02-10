package com.tistory.devs0n.visitor.doubledispatch

// Client
fun main() {
//    val snsList = listOf<SNS>(Facebook(), Twitter())
    val snsList = listOf<SNS>(Facebook(), Twitter(), Instagram())
    val posts = listOf<Post>(Text(), Picture())

    posts.forEach { post ->
        snsList.forEach { sns -> post.postOn(sns) }
    }
}
