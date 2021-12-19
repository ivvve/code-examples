package com.tistory.devs0n.abstractfactory.book.listfactory

import com.tistory.devs0n.abstractfactory.book.factory.Link

class ListLink(caption: String, url: String) : Link(caption, url) {
    override fun makeHTML(): String {
        return """<li><a href="${super.url}">${super.caption}</a></li>"""
    }
}
