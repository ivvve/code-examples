package com.tistory.devs0n.profile

import com.tistory.devs0n.profile.condition.LocalDevelopProfileCondition
import com.tistory.devs0n.profile.condition.LocalProfileCondition
import com.tistory.devs0n.profile.condition.NotLocalProfileCondition
import com.tistory.devs0n.profile.profile.Profile
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.springframework.context.annotation.AnnotationConfigApplicationContext
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Conditional
import org.springframework.context.annotation.Configuration


class ConditionalTest {
    @Test
    fun `local 환경`() {
        val ac = AnnotationConfigApplicationContext()
        ac.environment.setActiveProfiles(Profile.LOCAL.value)
        ac.register(ConditionalBean::class.java)
        ac.refresh()

        assertThat(ac.beanDefinitionNames.contains("localBean")).isTrue
        assertThat(ac.beanDefinitionNames.contains("localDevelopBean")).isTrue
        assertThat(ac.beanDefinitionNames.contains("notLocalDevelopBean")).isFalse
    }

    @Test
    fun `develop 환경`() {
        val ac = AnnotationConfigApplicationContext()
        ac.environment.setActiveProfiles(Profile.DEVELOP.value)
        ac.register(ConditionalBean::class.java)
        ac.refresh()

        assertThat(ac.beanDefinitionNames.contains("localBean")).isFalse
        assertThat(ac.beanDefinitionNames.contains("localDevelopBean")).isTrue
        assertThat(ac.beanDefinitionNames.contains("notLocalDevelopBean")).isTrue
    }

    @Configuration
    class ConditionalBean {
        @Bean("localBean")
        @Conditional(LocalProfileCondition::class)
        fun localBean(): ConditionalBean = ConditionalBean()

        @Bean("localDevelopBean")
        @Conditional(LocalDevelopProfileCondition::class)
        fun localDevelopBean(): ConditionalBean = ConditionalBean()

        @Bean("notLocalDevelopBean")
        @Conditional(NotLocalProfileCondition::class)
        fun notLocalBean(): ConditionalBean = ConditionalBean()
    }
}
