package com.tistory.devs0n.abstractfactory.book.tablefactory

import com.tistory.devs0n.abstractfactory.book.factory.Item
import com.tistory.devs0n.abstractfactory.book.factory.Page

class TablePage(title: String, author: String) : Page(title, author) {
    override fun makeHTML(): String {
        return """
            <html>
                <head>
                    <meta charset="utf-8"/>
                    <title>${super.title}</title>
                </head> 
                <body>
                    <h1>${super.title}</h1>
                    
                    <table width="80%" border="3">
                        ${this.contentsToTrs(super.contents)}
                    </table>
                    
                    <hr>
                    <address>${super.author}</address>
                </body>
            </html>
            """.trimIndent()
    }

    private fun contentsToTrs(contents: List<Item>): String {
        return contents.joinToString("\n") { this.contentToTr(it) }
    }

    private fun contentToTr(content: Item): String {
        return "<tr>${content.makeHTML()}</tr>"
    }
}
