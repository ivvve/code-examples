package com.tistory.devs0n.visitor.doubledispatch

// Visitor
interface SNS {
    fun getName(): String

    fun post(text: Text)

    fun post(picture: Picture)
}

class Facebook : SNS {
    override fun getName(): String = "Facebook"

    override fun post(text: Text) {
        // Facebook Text process
        println("Text is posted on ${this.getName()}")
    }

    override fun post(picture: Picture) {
        // Facebook Picture process
        println("Picture is posted on ${this.getName()}")
    }
}

class Twitter : SNS {
    override fun getName(): String = "Twitter"

    override fun post(text: Text) {
        // Twitter Text process
        println("Text is posted on ${this.getName()}")
    }

    override fun post(picture: Picture) {
        // Twitter Picture process
        println("Picture is posted on ${this.getName()}")
    }
}

class Instagram: SNS {
    override fun getName(): String = "Instagram"

    override fun post(text: Text) {
        // Instagram Text process
        println("Text is posted on ${this.getName()}")
    }

    override fun post(picture: Picture) {
        // Instagram Picture process
        println("Picture is posted on ${this.getName()}")
    }
}
