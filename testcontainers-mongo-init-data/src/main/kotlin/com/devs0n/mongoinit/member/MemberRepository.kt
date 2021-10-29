package com.devs0n.mongoinit.member

import org.springframework.data.mongodb.repository.MongoRepository

interface MemberRepository : MongoRepository<Member, String>
