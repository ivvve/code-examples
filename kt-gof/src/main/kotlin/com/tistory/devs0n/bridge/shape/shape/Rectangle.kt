package com.tistory.devs0n.bridge.shape.shape

import com.tistory.devs0n.bridge.shape.drawing.Drawing

class Rectangle(drawing: Drawing) : Shape(drawing) {
    override fun draw() {
        println("Draw Rectangle!")
    }
}
