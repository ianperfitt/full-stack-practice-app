package com.example.javapracticemicroservice.controller;

import com.example.javapracticemicroservice.service.JavaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/java")
public class AutowiredController {

    @Autowired
    JavaService javaService;

    @RequestMapping("/autowire")
    public String respond() {
        System.out.println("IAN");

        return javaService.response();
    }
}
