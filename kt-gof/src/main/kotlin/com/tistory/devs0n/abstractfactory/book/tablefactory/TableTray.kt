package com.tistory.devs0n.abstractfactory.book.tablefactory

import com.tistory.devs0n.abstractfactory.book.factory.Tray

class TableTray(caption: String) : Tray(caption) {
    override fun makeHTML(): String {
        return """
            <td>
                <table width="100%" border="1">
                    <tr>
                        <td bgcolor="#cccccc" align="center" colspan="${super.tray.size}">
                            <b>${super.caption}</b>
                        </td>
                    </tr>
                    
                    <tr>
                        ${super.tray.joinToString("\n") { it.makeHTML() }}
                    <tr>
                </table>
            </td>
        """.trimIndent()
    }
}
