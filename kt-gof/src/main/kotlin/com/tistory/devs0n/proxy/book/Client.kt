package com.tistory.devs0n.proxy.book

fun main() {
    val printer = PrinterProxy("MyPrinter")
    println(printer.getPrinterName())
    printer.print("Hello, World!")
}
