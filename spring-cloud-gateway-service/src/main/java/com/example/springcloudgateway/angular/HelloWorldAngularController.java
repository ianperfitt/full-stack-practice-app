package com.example.springcloudgateway.angular;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

// TODO move Angular files to Spring Boot Angular-microservice
@RestController
@RequestMapping("/angular")
public class HelloWorldAngularController {

    private static final Logger LOGGER = LoggerFactory.getLogger(HelloWorldAngularController.class);

    @RequestMapping("/helloworld")
    String helloWorld() {

        LOGGER.info(String.format("HelloWorldAngularController -> Printing hello world from Angular hello world controller"));

        return "hello world angular";
    }
}