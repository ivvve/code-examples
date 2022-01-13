package com.tistory.devs0n.chainofresponsibility.book.support

import com.tistory.devs0n.chainofresponsibility.book.Trouble

class LimitSupport(
    name: String,
    val limit: Int,
) : Support(name) {
    override fun canResolve(trouble: Trouble): Boolean = (trouble.number < this.limit)
}
