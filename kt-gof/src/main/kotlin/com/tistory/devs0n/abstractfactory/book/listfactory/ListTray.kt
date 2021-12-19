package com.tistory.devs0n.abstractfactory.book.listfactory

import com.tistory.devs0n.abstractfactory.book.factory.Tray

class ListTray(caption: String) : Tray(caption) {
    override fun makeHTML(): String {
        return """
            <li>
                ${super.caption}
                <ul>
                    ${super.tray.joinToString(separator = "\n") { it.makeHTML() }}
                </ul>
            </li>
        """.trimIndent()
    }
}
