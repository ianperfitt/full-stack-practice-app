package com.example.springcloudgateway.sql;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

// TODO move SQL files to Spring Boot SQL-microservice
@RestController
@RequestMapping("/sql")
public class HelloWorldSQLController {

    private static final Logger LOGGER = LoggerFactory.getLogger(HelloWorldSQLController.class);

    @RequestMapping("/helloworld")
    String helloWorld() {

        LOGGER.info(String.format("HelloWorldSQLController -> Printing hello world from SQL hello world controller"));

        return "hello world SQL";
    }
}