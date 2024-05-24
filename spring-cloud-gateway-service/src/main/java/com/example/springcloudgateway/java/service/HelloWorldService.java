package com.example.springcloudgateway.java.service;

import com.example.springcloudgateway.GatewayController;
import com.example.springcloudgateway.java.repository.feign.clients.HelloWorldFeignClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class HelloWorldService {

    private static final Logger LOGGER = LoggerFactory.getLogger(GatewayController.class);

    @Autowired
    private HelloWorldFeignClient helloWorldClient;

    public String helloWorld() {

        LOGGER.info(String.format("JavaService -> Calling helloWorld() method in JavaClient"));

        return helloWorldClient.helloWorld();
    }

}