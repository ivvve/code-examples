package com.tistory.devs0n.bridge.shape.shape

import com.tistory.devs0n.bridge.shape.drawing.Drawing

abstract class Shape(
    protected val drawing: Drawing
) {
    // 확장 가능한 기능
    abstract fun draw()

    // Implementation으로 위임한 기능
    fun drawLine() {
        this.drawing.drawLine()
    }

    fun fill() {
        this.drawing.fill()
    }
}
