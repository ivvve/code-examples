package com.tistory.devs0n.chainofresponsibility.book.support

import com.tistory.devs0n.chainofresponsibility.book.Trouble

abstract class Support(
    val name: String,
) {
    private var next: Support? = null

    fun setNext(next: Support): Support {
        this.next = next
        return next
    }

    fun support(trouble: Trouble) {
        if (this.canResolve(trouble)) {
            this.resolve(trouble)

        } else if (this.hasNext()) {
            this.next!!.support(trouble)

        } else {
            this.fail(trouble)
        }
    }

    protected abstract fun canResolve(trouble: Trouble): Boolean

    private fun resolve(trouble: Trouble) {
        println("[${this.name}] $trouble is resolved")
    }

    private fun fail(trouble: Trouble) {
        println("[${this.name}] Cannot resolve $trouble")
    }

    private fun hasNext(): Boolean = (this.next != null)
}
