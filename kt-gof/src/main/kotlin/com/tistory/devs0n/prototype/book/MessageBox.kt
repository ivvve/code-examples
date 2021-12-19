package com.tistory.devs0n.prototype.book

/**
 * 문자열을 테두리로 꾸미는 Product
 */
class MessageBox(
    private val decoChar: Char
) : Product {

    override fun use(string: String) {
        val bytesSize = string.toByteArray().size

        // print upper box line
        repeat(bytesSize + 4) {
            print(decoChar)
        }
        println()

        println("$decoChar $string $decoChar")

        // print lower box line
        repeat(bytesSize + 4) {
            print(decoChar)
        }
        println()
    }

    override fun createClone(): Product = this.clone() as Product

    override fun clone(): Any {
        return super.clone()
    }
}
