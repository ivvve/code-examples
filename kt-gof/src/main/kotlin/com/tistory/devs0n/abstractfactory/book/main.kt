package com.tistory.devs0n.abstractfactory.book

import com.tistory.devs0n.abstractfactory.book.factory.Factory

class Client(
    private val factory: Factory,
) {
    fun create() {
        val page = factory.createPage("TablePage", "사이트 목록")

        val newsTray = factory.createTray("신문")
        newsTray.add(factory.createLink("중앙일보", "www.joonang.com"))
        newsTray.add(factory.createLink("조선일보", "www.chosun.com"))

        val searchTray = factory.createTray("검색")
        searchTray.add(factory.createLink("구글", "google.com"))
        searchTray.add(factory.createLink("네이버", "naver.com"))
        searchTray.add(factory.createLink("다음", "daum.net"))

        page.add(newsTray)
        page.add(searchTray)

        println(page.makeHTML())
        page.output()
    }
}

fun main() {
    val client1 = Client(Factory.getFactory("com.tistory.devs0n.abstractfactory.book.tablefactory.TableFactory"))
    client1.create()

    val client2 = Client(Factory.getFactory("com.tistory.devs0n.abstractfactory.book.listfactory.ListFactory"))
    client2.create()

}
