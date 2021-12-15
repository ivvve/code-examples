package com.tistory.devs0n.singleton

class Settings3 {
    private constructor()

    companion object {
        // eager initialization
        private val INSTANCE: Settings3 = Settings3()

        fun getInstance(): Settings3 {
            return INSTANCE
        }
    }
}
