package com.tistory.devs0n.bridge.shape

import com.tistory.devs0n.bridge.shape.drawing.CircleDrawing
import com.tistory.devs0n.bridge.shape.drawing.RectangleDrawing
import com.tistory.devs0n.bridge.shape.shape.Circle
import com.tistory.devs0n.bridge.shape.shape.Rectangle
import com.tistory.devs0n.bridge.shape.shape.Shape

fun main() {
    val rectangle: Shape = Rectangle(RectangleDrawing())
    val circle: Shape = Circle(CircleDrawing())

    rectangle.drawLine()
    rectangle.draw()
    rectangle.fill()
}
