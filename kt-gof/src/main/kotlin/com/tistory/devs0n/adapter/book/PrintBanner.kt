package com.tistory.devs0n.adapter.book

// Adapter
class PrintBanner(string: String) : Print {
    private val banner = Banner(string)

    override fun printWeak() {
        this.banner.showWishParen()
    }

    override fun printStrong() {
        this.banner.showWishAster()
    }
}
