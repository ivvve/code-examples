package com.tistory.devs0n.abstractfactory.book.listfactory

import com.tistory.devs0n.abstractfactory.book.factory.Page

class ListPage(title: String, author: String) : Page(title, author) {
    override fun makeHTML(): String {
        return """
            <html>
                <head>
                    <meta charset="utf-8"/>
                    <title>${super.title}</title>
                </head> 
                <body>
                    <h1>${super.title}</h1>
                    
                    <ul>
                        ${super.contents.joinToString(separator = "\n") { it.makeHTML() }}                         
                    </ul>
                    
                    <hr>
                    <address>${super.author}</address>
                </body>
            </html>
            """.trimIndent()
    }
}
