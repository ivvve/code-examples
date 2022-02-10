package com.tistory.devs0n.visitor.lecture.element

import com.tistory.devs0n.visitor.lecture.visitor.Device

class Triangle : Shape {
    override fun accept(device: Device) {
        device.print(this)
    }
}
