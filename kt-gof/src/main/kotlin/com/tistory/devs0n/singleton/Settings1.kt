package com.tistory.devs0n.singleton

class Settings1 {
    private constructor()

    companion object {
        private var INSTANCE: Settings1? = null

        fun getInstance(): Settings1 {
            if (INSTANCE == null) {
                INSTANCE = Settings1()
            }

            return INSTANCE!!
        }
    }
}
