package com.tistory.devs0n.sample.mongodb

import org.springframework.data.repository.CrudRepository

interface MongoDBEntityRepository : CrudRepository<MongoDBEntity, String>
