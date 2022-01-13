package com.tistory.devs0n.builder.html

class HTML {
    fun init() {}
    fun head(init: Head.() -> Unit) {}
    fun body(init: Body.() -> Unit) {}
}

class Head

class Body

fun html(init: HTML.() -> Unit): HTML {
    return HTML().apply { this.init() }
}
