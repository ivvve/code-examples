package io.github.ivvve.multids.first

import org.springframework.data.jpa.repository.JpaRepository

interface FirstEntityRepository : JpaRepository<FirstEntity, Long> {
}