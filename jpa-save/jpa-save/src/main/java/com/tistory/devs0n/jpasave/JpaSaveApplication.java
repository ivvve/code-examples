package com.tistory.devs0n.jpasave;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(
    basePackages = {
        "io.hypersistence.utils.spring.repository",
        "com.tistory.devs0n.jpasave"
    }
)
public class JpaSaveApplication {

    public static void main(String[] args) {
        var ac = SpringApplication.run(JpaSaveApplication.class, args);

        System.out.println("----------------");

        var updatePostService = ac.getBean(UpdatePostService.class);
        updatePostService.update(1L, "새제목", "새내용");

        System.out.println("----------------");
    }
}
