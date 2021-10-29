package com.devs0n.mongoinit.member

import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class MemberService(
    private val memberRepository: MemberRepository
) {
    @Transactional
    fun joinNewMember(command: JoinNewMemberCommand): Member {
        return this.memberRepository.save(
            Member(name = command.name, address = command.address)
        )
    }

    fun getMember(memberId: String): Member {
        return this.memberRepository.findById(memberId)
            .orElseThrow { RuntimeException("NotFound") }
    }
}

data class JoinNewMemberCommand(
    val name: String,
    val address: String,
)
