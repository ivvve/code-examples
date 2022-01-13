package com.tistory.devs0n.servicelayertest.application

import com.tistory.devs0n.servicelayertest.domain.Member
import com.tistory.devs0n.servicelayertest.domain.MemberRepository
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class MemberService(
    private val memberRepository: MemberRepository
) {
    @Transactional
    fun joinNewMember(name: String) {
        this.memberRepository.findByName(name)
        Member()
    }
}
