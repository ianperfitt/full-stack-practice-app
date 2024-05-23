package com.example.springcloudgateway.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(name = "java-service", url = "http://localhost:8081")
public interface JavaClient {

    @RequestMapping(method = RequestMethod.GET, value = "/java/autowire")
    String autowire();
}