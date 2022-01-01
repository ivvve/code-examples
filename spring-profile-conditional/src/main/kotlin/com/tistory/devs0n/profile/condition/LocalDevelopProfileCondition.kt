package com.tistory.devs0n.profile.condition

import com.tistory.devs0n.profile.profile.Profile

class LocalDevelopProfileCondition : BaseProfileCondition() {
    override fun getTargetProfiles(): List<Profile> = listOf(Profile.LOCAL, Profile.DEVELOP)
}
