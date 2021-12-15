package com.tistory.devs0n.singleton

class Settings2 {
    private constructor()

    companion object {
        private var INSTANCE: Settings2? = null

        @Synchronized
        fun getInstance(): Settings2 {
            if (INSTANCE == null) {
                INSTANCE = Settings2()
            }

            return INSTANCE!!
        }
    }
}
