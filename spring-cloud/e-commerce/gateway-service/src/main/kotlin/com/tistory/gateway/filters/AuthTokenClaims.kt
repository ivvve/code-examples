package com.tistory.gateway.filters

data class AuthTokenClaims(
    val userId: String
) {
    companion object {
        const val USER_ID_CLAIMS_KEY = "user_id"
    }
}
