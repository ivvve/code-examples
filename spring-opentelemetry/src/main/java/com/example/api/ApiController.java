package com.example.api;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

@RestController
public class ApiController {
    private static final Logger log = LoggerFactory.getLogger(ApiController.class);

    private final AsyncService asyncService;

    public ApiController(AsyncService asyncService) {
        this.asyncService = asyncService;
    }

    @GetMapping("/hello")
    public ResponseEntity<Data> hello(@RequestParam String a, @RequestParam String b) {
        log.info("/hello called - a={} b={}", a, b);
        this.asyncService.runAsync(a, b);

        return ResponseEntity.ok(
                new Data("Hello, world!", LocalDateTime.now().toString())
        );
    }

    @PostMapping("/post")
    public ResponseEntity<Data> post(@RequestBody Data data) {
        return ResponseEntity.ok(data);
    }

    record Data(String a, String b) {
    }
}

