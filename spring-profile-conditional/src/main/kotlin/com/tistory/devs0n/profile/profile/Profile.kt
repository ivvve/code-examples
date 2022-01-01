package com.tistory.devs0n.profile.profile

enum class Profile(
    val value: String
) {
    LOCAL("local"),
    DEVELOP("develop"),
    QA("qa"),
    STAGE("stage"),
    PROD("prod");

    fun isEqualTo(profile: String): Boolean = (this.value == profile)
}
