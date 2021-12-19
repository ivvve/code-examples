package com.tistory.devs0n.builder.book

import java.io.FileWriter
import java.io.PrintWriter

/**
 * HTML을 사용해서 문서를 만든다
 */
class HTMLBuilder : Builder {
    private var fileName: String = ""
    private lateinit var writer: PrintWriter

    override fun makeTitle(title: String): Builder {
        this.fileName = "${title}.html"
        this.writer = PrintWriter(FileWriter(this.fileName))

        this.writer.println("<html>")
        this.writer.println("<head>")
        this.writer.println("""<meta charset="utf-8"/>""")
        this.writer.println("<title>${title}</title>")
        this.writer.println("</head>")
        this.writer.println("<body>")
        this.writer.println("<h1>${title}</h1>")

        return this
    }

    override fun makeString(string: String): Builder {
        this.writer.println("<p>${string}</p>")
        return this
    }

    override fun makeItems(items: List<String>): Builder {
        this.writer.println("<ul>")
        for (item in items) {
            this.writer.println("<li>${item}</li>")
        }
        this.writer.println("</ul>")
        return this
    }

    override fun close(): Builder {
        this.writer.println("</body>")
        this.writer.println("</html>")

        this.writer.close()
        return this
    }

    override fun getResult(): String {
        return this.fileName
    }
}
