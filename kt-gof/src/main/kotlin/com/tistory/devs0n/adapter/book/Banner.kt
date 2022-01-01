package com.tistory.devs0n.adapter.book

// 미리 제공되어 변경할 수 없는 클래스
class Banner(
    private val string: String
) {
    fun showWishParen() {
        println("{${this.string}}")
    }

    fun showWishAster() {
        println("*${this.string}*")
    }
}
