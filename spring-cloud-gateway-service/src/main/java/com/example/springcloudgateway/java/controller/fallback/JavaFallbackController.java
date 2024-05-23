package com.example.springcloudgateway.java.controller.fallback;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
public class JavaFallbackController {

    private static final Logger LOGGER = LoggerFactory.getLogger(JavaFallbackController.class);

    @RequestMapping("/fallback")
    public Mono<String> fallback() {

        LOGGER.info(String.format("FallbackController -> In fallback method !"));

        return Mono.just("fallback is working !");
    }
}
