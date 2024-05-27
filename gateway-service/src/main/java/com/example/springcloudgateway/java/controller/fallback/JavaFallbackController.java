package com.example.springcloudgateway.java.controller.fallback;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import reactor.core.publisher.Mono;

@RestController
public class JavaFallbackController {

    private static final Logger LOGGER = LoggerFactory.getLogger(JavaFallbackController.class);

    RestTemplate restTemplate;

    JavaFallbackController(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @RequestMapping("/fallback")
    public Mono<String> fallback() {

        LOGGER.info(String.format("FallbackController -> In fallback method !"));

        return Mono.just("fallback is working !");
    }

    @RequestMapping("/resilience4j-fallback")
    public Mono<String> resilience() {

        LOGGER.info(String.format("JavaFallbackController -> About to call resilience method in java service!"));

        restTemplate.getForObject("http://localhost:8081/java/resilience4j-fallback", String.class);

        return Mono.just("resilience4j fallback is working !");
    }
}
