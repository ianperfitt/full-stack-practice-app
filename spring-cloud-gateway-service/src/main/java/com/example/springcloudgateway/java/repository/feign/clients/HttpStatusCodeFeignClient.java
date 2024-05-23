package com.example.springcloudgateway.java.repository.feign.clients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(name = "http-status-code-feign-client", url = "http://localhost:8081/java")
public interface HttpStatusCodeFeignClient {

    @RequestMapping(method = RequestMethod.GET, value = "/http-status/bad-request")
    ResponseEntity<?> badRequest();

    @RequestMapping(method = RequestMethod.GET, value = "/http-status/unauthorized")
    ResponseEntity<?> unauthorized();

    @RequestMapping(method = RequestMethod.GET, value = "/http-status/forbidden")
    ResponseEntity<?> forbidden();

    @RequestMapping(method = RequestMethod.GET, value = "/http-status/resource-not-found")
    ResponseEntity<?> resourceNotFound();

    @RequestMapping(method = RequestMethod.GET, value = "/http-status/internal-server-error")
    ResponseEntity<?> internalServerError();

    @RequestMapping(method = RequestMethod.GET, value = "/http-status/ok")
    ResponseEntity<?> ok();

    @RequestMapping(method = RequestMethod.GET, value = "/http-status/created")
    ResponseEntity<?> created();
}
