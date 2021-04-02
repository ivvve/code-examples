package com.tistory.devs0n.ktvalidation.entity

class Board {
    var title: String
        private set(value) {
            if ((value.length < 5) or (50 < value.length)) {
                throw IllegalArgumentException()
            }
            field = value
        }

    var content: String
        private set(value) {
            if (value.isBlank()) {
                throw IllegalArgumentException()
            }
            field = value
        }

    constructor(title: String, content: String) {
        this.title = title
        this.content = content
    }

    fun update(title: String, content: String) {
        this.title = title
        this.content = content
    }
}
