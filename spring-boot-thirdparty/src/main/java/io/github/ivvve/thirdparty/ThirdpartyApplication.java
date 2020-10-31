package io.github.ivvve.thirdparty;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
public class ThirdpartyApplication {

    public static void main(String[] args) {
        SpringApplication.run(ThirdpartyApplication.class, args);
    }

}

@Slf4j
@RestController
class HelloWorldController {
    @GetMapping("/debug")
    public String debug() {
        log.debug("debug");
        return "debug";
    }

    @GetMapping("/info")
    public String info() {
        log.info("info");
        return "info";
    }

    @GetMapping("/warn")
    public String warn() {
        log.warn("warn");
        return "warn";
    }

    @GetMapping("/error")
    public String error() {
        log.error("error");
        return "error";
    }
}
