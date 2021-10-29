package com.devs0n.mongoinit.member

import com.devs0n.mongoinit.IntegrationTest
import com.devs0n.mongoinit.MongodbTestcontainersExtension
import org.junit.jupiter.api.Assertions.*
import org.assertj.core.api.Assertions.*
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.springframework.beans.factory.annotation.Autowired

internal class MemberServiceTest : IntegrationTest() {
    @Autowired
    lateinit var memberRepository: MemberRepository

    @Test
    fun `test init script`() {
        val memberOptional = this.memberRepository.findById("chris")

        assertThat(memberOptional).isNotNull
        val member = memberOptional.get()

        assertThat(member.id).isEqualTo("chris")
        assertThat(member.name).isEqualTo("Chris")
        assertThat(member.address).isEqualTo("Seoul")
    }
}
