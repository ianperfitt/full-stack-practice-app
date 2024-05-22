package com.example.springcloudgateway.controller.java;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/java")
public class HelloWorldController {

    @RequestMapping("/helloworld")
    String helloWorld() {
        return "hello world";
    }
}