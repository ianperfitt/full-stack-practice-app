package com.example.springcloudgateway.java.controller;

import com.example.springcloudgateway.java.service.AutowiredService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

// controller for practicing @Autowired concepts
@RestController
@RequestMapping("/java")
public class AutowiredController {

    private static final Logger LOGGER = LoggerFactory.getLogger(AutowiredController.class);

    @Autowired
    private AutowiredService autoWiredService;

    @RequestMapping("/autowired")
    public ResponseEntity<?> respond() {

        LOGGER.info(String.format("AutowiredController -> About to call JavaService.autowire()"));

        String s = autoWiredService.autowire();
        ResponseEntity<?> response = new ResponseEntity(s, HttpStatus.OK);
        return response;
    }
}
