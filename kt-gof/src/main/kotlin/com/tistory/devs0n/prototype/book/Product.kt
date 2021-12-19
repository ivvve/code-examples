package com.tistory.devs0n.prototype.book

/**
 * 문자열을 꾸미는 프로그램
 */
interface Product : Cloneable {
    fun use(string: String)

    fun createClone(): Product
}
