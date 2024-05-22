package com.example.springcloudgateway.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/java")
public class JavaController {

    @RequestMapping("/helloworld")
    String helloWorld() {
        return "hello world";
    }
}