package com.tistory.devs0n.abstractfactory.book.tablefactory

import com.tistory.devs0n.abstractfactory.book.factory.Link

class TableLink(caption: String, url: String) : Link(caption, url) {
    override fun makeHTML(): String {
        return """<td><a href="${super.url}">${super.caption}</a></td>"""
    }
}
