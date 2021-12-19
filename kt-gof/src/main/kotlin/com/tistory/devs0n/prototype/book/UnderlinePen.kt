package com.tistory.devs0n.prototype.book

/**
 * 문자열을 밑줄로 꾸미는 Product
 */
class UnderlinePen(
    private val ulChar: Char
) : Product {
    override fun use(string: String) {
        println("\"$string\"")

        // print underline
        print(" ")
        repeat(string.toByteArray().size) {
            print(this.ulChar)
        }
        println(" ")
    }

    override fun createClone(): Product = this.clone() as UnderlinePen
}
