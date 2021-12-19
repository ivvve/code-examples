package com.tistory.devs0n.builder.book

/**
 * 주어진 Builder를 사용하여 정해진 문서를 생성한다
 */
class Director(
    private val builder: Builder
) {
    fun construct(): String = this.builder
        .makeTitle("인사말")
        .makeString("아침과 낮에")
        .makeItems(
            listOf(
                "좋은 아침입니다.",
                "안녕하세요.",
            )
        )
        .makeString("밤에")
        .makeItems(
            listOf(
                "안녕하세요.",
                "안녕히 주무세요.",
                "안녕히 계세요.",
            )
        )
        .close()
        .getResult()
}
