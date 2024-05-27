package com.example.springcloudgateway.java.controller;


import com.example.springcloudgateway.java.service.HelloWorldService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/java")
public class HelloWorldJavaController {

    private static final Logger LOGGER = LoggerFactory.getLogger(HelloWorldJavaController.class);

    @Autowired
    private HelloWorldService javaService;

    @RequestMapping("/helloworld")
    ResponseEntity<?> helloWorld() {

        LOGGER.info(String.format("HelloWorldJavaController -> About to call JavaService.helloworld()"));

        String s = javaService.helloWorld();
        ResponseEntity<?> response = new ResponseEntity(s, HttpStatus.OK);
        return response;
    }
}