package com.tistory.devs0n.proxy.book

interface Printable {
    fun setPrinterName(name: String)

    fun getPrinterName(): String

    fun print(message: String)
}
