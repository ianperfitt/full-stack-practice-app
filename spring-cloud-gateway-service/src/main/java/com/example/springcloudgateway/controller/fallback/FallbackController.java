package com.example.springcloudgateway.controller.fallback;

import com.example.springcloudgateway.controller.GatewayController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
public class FallbackController {

    private static final Logger LOGGER = LoggerFactory.getLogger(FallbackController.class);

    @RequestMapping("/fallback")
    public Mono<String> fallback() {

        LOGGER.info(String.format("FallbackController -> In fallback method !"));

        return Mono.just("fallback is working !");
    }
}
