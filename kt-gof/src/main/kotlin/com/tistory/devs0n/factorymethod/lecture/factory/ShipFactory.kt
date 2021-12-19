package com.tistory.devs0n.factorymethod.lecture.factory

import com.tistory.devs0n.factorymethod.lecture.ship.Ship

interface ShipFactory {
    fun orderShip(name: String, email: String): Ship {
        this.validateName(name)
        this.validateEmail(email)

        this.prepareFor(name)
        val ship = this.createShip()
        this.sendEmailTo(email)

        return ship
    }

    private fun validateName(name: String) {
        if (name.isBlank()) {
            throw IllegalArgumentException()
        }
    }

    private fun validateEmail(email: String) {
        if (email.isBlank()) {
            throw IllegalArgumentException()
        }
    }

    private fun prepareFor(name: String) {
        println("$name 만드는 중...")
    }

    private fun sendEmailTo(email: String) {
        println("[$email] 다 만들었습니다")
    }

    fun createShip(): Ship
}
