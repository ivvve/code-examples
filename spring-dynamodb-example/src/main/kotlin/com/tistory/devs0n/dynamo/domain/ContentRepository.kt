package com.tistory.devs0n.dynamo.domain

import org.springframework.data.repository.CrudRepository

interface ContentRepository : CrudRepository<Content, String>
