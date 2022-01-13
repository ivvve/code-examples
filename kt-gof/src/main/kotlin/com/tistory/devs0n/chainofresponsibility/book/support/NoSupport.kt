package com.tistory.devs0n.chainofresponsibility.book.support

import com.tistory.devs0n.chainofresponsibility.book.Trouble

class NoSupport(name: String) : Support(name) {
    override fun canResolve(trouble: Trouble): Boolean = false
}
