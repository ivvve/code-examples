package com.tistory.devs0n.interpreter.lecture.expression

// Abstract Expression
interface PostfixExpression {
    fun interpret(context: Map<Char, Int>): Int
}
