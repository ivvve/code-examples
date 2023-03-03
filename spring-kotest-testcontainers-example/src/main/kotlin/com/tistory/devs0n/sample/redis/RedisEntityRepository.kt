package com.tistory.devs0n.sample.redis

import org.springframework.data.repository.CrudRepository

interface RedisEntityRepository : CrudRepository<RedisEntity, String>
