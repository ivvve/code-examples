package com.tistory.devs0n.interpreter.lecture.expression

// Terminal Expression
class VariableExpression(
    val char: Char,
) : PostfixExpression {
    override fun interpret(context: Map<Char, Int>): Int = context[this.char]!!
}
