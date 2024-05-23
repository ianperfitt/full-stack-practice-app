package com.example.springcloudgateway.service;

import com.example.springcloudgateway.controller.GatewayController;
import com.example.springcloudgateway.feign.JavaClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class JavaService {

    private static final Logger LOGGER = LoggerFactory.getLogger(GatewayController.class);

    @Autowired
    private JavaClient javaClient;

    public String autowire() {

        LOGGER.info(String.format("JavaService -> Calling autowire() method in JavaClient"));

        return javaClient.autowire();
    }
}