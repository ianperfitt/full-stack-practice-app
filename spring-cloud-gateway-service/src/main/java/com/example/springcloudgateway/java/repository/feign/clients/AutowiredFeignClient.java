package com.example.springcloudgateway.java.repository.feign.clients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(name = "autowired-feign-client", url = "http://localhost:8081/java")
public interface AutowiredFeignClient {

    @RequestMapping(method = RequestMethod.GET, value = "/autowire")
    String autowire();
}
