package com.tistory.devs0n.abstractfactory.book.tablefactory

import com.tistory.devs0n.abstractfactory.book.factory.Factory
import com.tistory.devs0n.abstractfactory.book.factory.Link
import com.tistory.devs0n.abstractfactory.book.factory.Page
import com.tistory.devs0n.abstractfactory.book.factory.Tray

class TableFactory : Factory() {
    override fun createLink(caption: String, url: String): Link = TableLink(caption, url)

    override fun createTray(caption: String): Tray = TableTray(caption)

    override fun createPage(title: String, author: String): Page = TablePage(title, author)
}
