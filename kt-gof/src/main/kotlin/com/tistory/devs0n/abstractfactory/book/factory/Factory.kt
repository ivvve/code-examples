package com.tistory.devs0n.abstractfactory.book.factory

abstract class Factory {
    abstract fun createLink(caption: String, url: String): Link

    abstract fun createTray(caption: String): Tray

    abstract fun createPage(title: String, author: String): Page

    companion object {
        fun getFactory(className: String) =
            Class.forName(className).getDeclaredConstructor().newInstance() as Factory
    }
}
