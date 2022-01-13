package com.tistory.devs0n.tf

import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.client.RestTemplate

@RestController
class InstanceController {
    @GetMapping("/instance")
    fun getInstanceId(): ResponseEntity<String> {
        val instanceIdResponseEntity = RestTemplate().getForEntity("http://169.254.169.254/latest/meta-data/instance-id", String::class.java)
        return ResponseEntity.ok(instanceIdResponseEntity.body!!)
    }
}
