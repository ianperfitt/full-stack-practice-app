package com.example.springcloudgateway.controller.java;

import com.example.springcloudgateway.service.JavaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

// controller for practicing @Autowired concepts
@RestController
@RequestMapping("/java")
public class AutowiredController {

    private JavaService javaServiceConstructor;

    private JavaService javaServiceSetter;

    // field injection
    @Autowired
    private JavaService javaServiceField;

    // constructor injection
    @Autowired
    AutowiredController(JavaService javaService) {
        this.javaServiceConstructor = javaService;
    }

    // setter injection
    @Autowired
    public void setJavaService(JavaService javaService) {
        this.javaServiceSetter = javaService;
    }

    @RequestMapping("/autowired")
    public ResponseEntity<?> respond() {
        String constructorResponse = javaServiceConstructor.response();
        String setterResponse = javaServiceSetter.response();
        String fieldResponse = javaServiceField.response();
        constructorResponse = constructorResponse + " using constructor injection!";
        setterResponse = setterResponse + " using setter injection!";
        fieldResponse = fieldResponse + " using field injection!";
        StringBuilder sb = new StringBuilder();
        sb.append(constructorResponse);
        sb.append("\n");
        sb.append(setterResponse);
        sb.append("\n");
        sb.append(fieldResponse);
        ResponseEntity<?> response = new ResponseEntity(sb.toString(), HttpStatus.OK);
        return response;
    }
}
