package com.tistory.devs0n.facade.book

import java.io.Writer

class HtmlWriter(
    private val writer: Writer
) {

    fun title(title: String) {
        this.writer.write("""
            <html>
                <head>
                    <title>${title}</title>
                </head>
                <body>
                    <h1>${title}</h1>
        """.trimIndent())
    }

    fun paragraph(msg: String) {
        this.writer.write("<p>${msg}</p>")
    }

    fun link(href: String, caption: String) {
        this.paragraph("""<a href="${href}">${caption}</a>""")
    }

    fun mailto(mailAddress: String, username: String) {
        this.link("mailto:${mailAddress}", username)
    }

    fun close() {
        this.writer.write("""
                </body>
            </html>
        """.trimMargin())
        this.writer.close()
    }
}
