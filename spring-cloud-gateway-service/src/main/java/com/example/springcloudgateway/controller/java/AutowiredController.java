package com.example.springcloudgateway.controller.java;

import com.example.springcloudgateway.controller.GatewayController;
import com.example.springcloudgateway.service.JavaService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

// controller for practicing @Autowired concepts
@RestController
public class AutowiredController {

    private static final Logger LOGGER = LoggerFactory.getLogger(AutowiredController.class);

    @Autowired
    private JavaService javaService;

    @RequestMapping("java/autowired")
    public ResponseEntity<?> respond() {

        LOGGER.info(String.format("AutowiredController -> In AutowiredController and about to call JavaService.autowire()"));

        String s = javaService.autowire();
        ResponseEntity<?> response = new ResponseEntity(s, HttpStatus.OK);
        return response;
    }
}
