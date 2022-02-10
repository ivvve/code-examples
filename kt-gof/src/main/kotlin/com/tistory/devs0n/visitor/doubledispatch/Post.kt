package com.tistory.devs0n.visitor.doubledispatch

// Element
interface Post {
    fun postOn(sns: SNS)

//    fun postOn(facebook: Facebook)
//
//    fun postOn(twitter: Twitter)
}

class Text : Post {
    override fun postOn(sns: SNS) {
//        println("Text is posted on ${sns.getName()}")
        sns.post(this)
    }
}

class Picture : Post {
    override fun postOn(sns: SNS) {
//        println("Picture is posted on ${sns.getName()}")
        sns.post(this)
    }
}
