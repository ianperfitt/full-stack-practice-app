package com.example.springcloudgateway.java.service;

import com.example.springcloudgateway.GatewayController;
import com.example.springcloudgateway.java.repository.feign.clients.AutowiredFeignClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AutowiredService {

    private static final Logger LOGGER = LoggerFactory.getLogger(GatewayController.class);

    @Autowired
    private AutowiredFeignClient autowiredClient;

    public String autowire() {

        LOGGER.info(String.format("JavaService -> Calling autowire() method in JavaClient"));

        return autowiredClient.autowire();
    }
}
