package com.tistory.devs0n.chainofresponsibility.book.support

import com.tistory.devs0n.chainofresponsibility.book.Trouble

class SpecialSupport(
    name: String,
    val number: Int
) : Support(name) {
    override fun canResolve(trouble: Trouble): Boolean = (this.number == trouble.number)
}
