package com.example.javapracticemicroservice.controller;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/java")
public class Resilience4JFallBackController {

    private static final Logger LOGGER = LoggerFactory.getLogger(Resilience4JFallBackController.class);

    @RequestMapping("/resilience4j-fallback")
    public ResponseEntity<?> resilience() {

        LOGGER.info("Resilience4JFallBackController:resilience() -> Fallback method !");

        return new ResponseEntity("All good !" ,HttpStatus.OK);

    }
}