package com.tistory.devs0n.abstractfactory.book.listfactory

import com.tistory.devs0n.abstractfactory.book.factory.Factory
import com.tistory.devs0n.abstractfactory.book.factory.Link
import com.tistory.devs0n.abstractfactory.book.factory.Page
import com.tistory.devs0n.abstractfactory.book.factory.Tray

class ListFactory : Factory() {
    override fun createLink(caption: String, url: String): Link = ListLink(caption, url)

    override fun createTray(caption: String): Tray = ListTray(caption)

    override fun createPage(title: String, author: String): Page = ListPage(title, author)
}
