package com.tistory.devs0n.bridge.book

// Refined Abstraction
class CountDisplay(impl: DisplayImpl) : Display(impl) {
    fun multiDisplay(times: Int) {
        super.open()
        repeat(times) { super.print() }
        super.close()
    }
}
