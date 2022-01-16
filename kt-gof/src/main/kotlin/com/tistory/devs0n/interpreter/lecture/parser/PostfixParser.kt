package com.tistory.devs0n.interpreter.lecture.parser

import com.tistory.devs0n.interpreter.lecture.expression.*
import java.util.*

class PostfixParser {
    companion object {
        fun parse(expression: String): PostfixExpression {
            val stack = Stack<PostfixExpression>()

            for (char in expression.toCharArray()) {
                val expression = this.getExpression(char, stack)
                stack.push(expression)
            }
            return stack.pop()
        }

        private fun getExpression(char: Char, stack: Stack<PostfixExpression>): PostfixExpression =
            when (char) {
                '+' -> {
                    val left = stack.pop()
                    val right = stack.pop()
                    PlusExpression(left, right)
                }
                '-' -> {
                    val right = stack.pop()
                    val left = stack.pop()
                    MinusExpression(left, right)
                }
                '*' -> MultiplyExpression(stack.pop(), stack.pop())
                else -> VariableExpression(char)
            }
    }
}
