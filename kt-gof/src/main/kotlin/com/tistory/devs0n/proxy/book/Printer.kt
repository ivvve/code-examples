package com.tistory.devs0n.proxy.book

class Printer : Printable {
    private var name: String

    constructor(name: String) {
        this.name = name
        this.load()
    }

    private fun load() {
        println("Printer 생성 중...")
        Thread.sleep(1_000)
    }

    override fun setPrinterName(name: String) {
        this.name = name
    }

    override fun getPrinterName(): String = this.name

    override fun print(message: String) {
        println("===${this.getPrinterName()}===")
        println(message)
    }
}
