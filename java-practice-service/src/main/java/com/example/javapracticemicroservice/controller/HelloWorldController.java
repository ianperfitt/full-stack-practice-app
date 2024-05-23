package com.example.javapracticemicroservice.controller;

import com.example.javapracticemicroservice.service.JavaService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/java")
public class HelloWorldController {

    private static final Logger LOGGER = LoggerFactory.getLogger(HelloWorldController.class);

    @Autowired
    JavaService javaService;

    @RequestMapping("/helloworld")
    public String respond() {
        LOGGER.info(String.format("HelloWorldController -> Calling helloWorld() method in JavaServiceImpl"));

        return javaService.helloWorld();
    }
}
