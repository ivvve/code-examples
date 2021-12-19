package com.tistory.devs0n.builder.book

/**
 * Plain Text를 사용해서 문서를 만든다
 */
class TextBuilder : Builder {
    private var text = ""

    override fun makeTitle(title: String): Builder {
        this.text += "============================\n"
        this.text += "[$title]\n"
        this.text += "\n"
        return this
    }

    override fun makeString(string: String): Builder {
        this.text += "# $string\n"
        this.text += "\n"
        return this
    }

    override fun makeItems(items: List<String>): Builder {
        for (item in items) {
            this.text += "- $item\n"
        }
        this.text += "\n"
        return this
    }

    override fun close(): Builder {
        this.text += "============================\n"
        return this
    }

    override fun getResult(): String = this.text
}
