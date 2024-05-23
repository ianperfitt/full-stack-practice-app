package com.example.springcloudgateway.service;

import com.example.springcloudgateway.feign.JavaClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class JavaService {

    @Autowired
    private JavaClient javaClient;

    public String autowire() {
        return javaClient.autowire();
    }
}