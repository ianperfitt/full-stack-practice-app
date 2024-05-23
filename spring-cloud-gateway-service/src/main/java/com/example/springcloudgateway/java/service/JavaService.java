package com.example.springcloudgateway.java.service;

import com.example.springcloudgateway.config.GatewayController;
import com.example.springcloudgateway.java.repository.feign.JavaClient;
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

    public String helloWorld() {

        LOGGER.info(String.format("JavaService -> Calling helloWorld() method in JavaClient"));

        return javaClient.helloWorld();
    }
}