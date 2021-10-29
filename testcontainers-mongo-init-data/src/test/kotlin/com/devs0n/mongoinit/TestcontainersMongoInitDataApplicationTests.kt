package com.devs0n.mongoinit

import com.devs0n.mongoinit.member.MemberRepository
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired

class TestcontainersMongoInitDataApplicationTests : IntegrationTest() {

    @Test
    fun contextLoads() {
    }

    @Autowired
    lateinit var memberRepository: MemberRepository

    @Test
    fun `test init script`() {
        val initMember = memberRepository.findById("chris")
        assertThat(initMember).isNotNull

        val member = initMember.get()
        assertThat(member.id).isEqualTo("chris")
        assertThat(member.name).isEqualTo("Chris")
        assertThat(member.address).isEqualTo("Seoul")
    }
}
