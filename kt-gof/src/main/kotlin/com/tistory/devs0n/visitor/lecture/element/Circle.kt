package com.tistory.devs0n.visitor.lecture.element

import com.tistory.devs0n.visitor.lecture.visitor.Device

class Circle : Shape {
    override fun accept(device: Device) {
        device.print(this)
    }
}
