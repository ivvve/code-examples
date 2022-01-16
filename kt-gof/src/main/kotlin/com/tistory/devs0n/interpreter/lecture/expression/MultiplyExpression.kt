package com.tistory.devs0n.interpreter.lecture.expression

// Nonterminal Expression
class MultiplyExpression(
    val left: PostfixExpression,
    val right: PostfixExpression,
) : PostfixExpression {
    override fun interpret(context: Map<Char, Int>): Int =
        this.left.interpret(context) * this.right.interpret(context)
}
