package com.tistory.devs0n.singleton

class Settings4 {
    private constructor()

    companion object {
        @Volatile
        private var INSTANCE: Settings4? = null

        // Double checked locking
        fun getInstance(): Settings4 {
            if (INSTANCE == null) {
                synchronized(Settings4::class) {
                    if (INSTANCE == null) {
                        INSTANCE = Settings4()
                    }
                }
            }

            return INSTANCE!!
        }
    }
}
