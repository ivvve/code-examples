package com.tistory.devs0n.profile.condition

import org.springframework.context.annotation.Condition
import org.springframework.context.annotation.ConditionContext
import org.springframework.core.type.AnnotatedTypeMetadata

class NotLocalProfileCondition : Condition {
    private val localProfileCondition = LocalProfileCondition()

    override fun matches(context: ConditionContext, metadata: AnnotatedTypeMetadata): Boolean =
        !this.localProfileCondition.matches(context, metadata)
}
