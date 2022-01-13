package com.tistory.devs0n.proxy.book

class PrinterProxy : Printable {
    private var name: String
    private var real: Printable? = null

    constructor(name: String) {
        this.name = name
    }

    override fun setPrinterName(name: String) {
        this.name = name
    }

    override fun getPrinterName(): String = this.name

    override fun print(message: String) {
        // 실제로 사용할 때까지 생성을 미룬다
        this.realize()
        this.real!!.print(message)
    }

    private fun realize() {
        if (this.real == null) {
            this.real = Printer(this.name)
        }
    }
}
