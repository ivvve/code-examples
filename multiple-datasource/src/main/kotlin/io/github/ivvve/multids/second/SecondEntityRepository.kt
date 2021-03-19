package io.github.ivvve.multids.second

import org.springframework.data.jpa.repository.JpaRepository

interface SecondEntityRepository : JpaRepository<SecondEntity, Long> {
}