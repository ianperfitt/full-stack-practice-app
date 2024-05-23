package com.example.springcloudgateway.controller.java;

import com.example.springcloudgateway.service.JavaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

// controller for practicing @Autowired concepts
@RestController
public class AutowiredController {

    @Autowired
    private JavaService javaService;

    @RequestMapping("java/autowired")
    public ResponseEntity<?> respond() {
        String s = javaService.autowire();
        System.out.println("SSSSSSSSS" + s);
        ResponseEntity<?> response = new ResponseEntity(s, HttpStatus.OK);
        return response;
    }
}
