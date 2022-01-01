package com.tistory.devs0n.profile.condition

import com.tistory.devs0n.profile.profile.Profile
import org.springframework.context.annotation.Condition
import org.springframework.context.annotation.ConditionContext
import org.springframework.core.type.AnnotatedTypeMetadata

abstract class BaseProfileCondition : Condition {
    override fun matches(context: ConditionContext, metadata: AnnotatedTypeMetadata): Boolean {
        val activeProfiles = context.environment.activeProfiles
        val targetProfiles = this.getTargetProfiles()

        return activeProfiles.any {
            this.isActiveProfileMatchedWithTargetProfiles(it, targetProfiles)
        }
    }

    abstract fun getTargetProfiles(): List<Profile>

    private fun isActiveProfileMatchedWithTargetProfiles(activeProfile: String, targetProfile: List<Profile>): Boolean =
        targetProfile.any { it.isEqualTo(activeProfile) }
}
