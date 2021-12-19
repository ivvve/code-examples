package com.tistory.devs0n.abstractfactory.book.factory

/**
 * HTML의 Hyperlink를 추상화한 클래스
 */
abstract class Link(
    caption: String,
    protected val url: String,
) : Item(caption)
