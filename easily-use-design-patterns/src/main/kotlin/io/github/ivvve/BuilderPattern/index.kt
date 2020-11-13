package io.github.ivvve.BuilderPattern

fun main() {
    val algorithm: Algorithm = ProductModel()
    val factory: Builder = Factory(algorithm)

    val computer = factory.build().getInstance()
    println(computer)
}