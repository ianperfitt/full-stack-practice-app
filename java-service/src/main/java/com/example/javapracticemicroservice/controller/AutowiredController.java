package com.example.javapracticemicroservice.controller;

import com.example.javapracticemicroservice.service.JavaService;
import com.example.javapracticemicroservice.service.JavaServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/java")
public class AutowiredController {

    private static final Logger LOGGER = LoggerFactory.getLogger(JavaServiceImpl.class);

    @Autowired
    JavaService javaService;

    @RequestMapping("/autowire")
    public String respond() {
        LOGGER.info(String.format("AutowiredController -> Calling response() method in JavaServiceImpl"));

        return javaService.response();
    }
}
