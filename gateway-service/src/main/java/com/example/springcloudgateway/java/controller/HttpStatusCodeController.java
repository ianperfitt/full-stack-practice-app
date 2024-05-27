package com.example.springcloudgateway.java.controller;

import com.example.springcloudgateway.java.service.HttpStatusCodeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/java/http-status")
public class HttpStatusCodeController {

    private static final Logger LOGGER = LoggerFactory.getLogger(HttpStatusCodeController.class);

    @Autowired
    private HttpStatusCodeService httpStatusCodeServiceService;

    @RequestMapping("/bad-request")
    public ResponseEntity<?> respond() {

        LOGGER.info(String.format("HttpStatusCodeController -> About to call HttpStatusCodeService.badRequest()"));

        ResponseEntity<?> response = httpStatusCodeServiceService.badRequest();
        return response;
    }

    @RequestMapping("/unauthorized")
    public ResponseEntity<?> unauthorized() {

        LOGGER.info(String.format("HttpStatusCodeController -> About to call HttpStatusCodeService.unauthorized()"));

        ResponseEntity<?> response = httpStatusCodeServiceService.unauthorized();
        return response;
    }

    @RequestMapping("/forbidden")
    public ResponseEntity<?> forbidden() {

        LOGGER.info(String.format("HttpStatusCodeController -> About to call HttpStatusCodeService.badRequest()"));

        ResponseEntity<?> response = httpStatusCodeServiceService.forbidden();
        return response;
    }

    @RequestMapping("/resource-not-found")
    public ResponseEntity<?> resourceNotFound() {

        LOGGER.info(String.format("HttpStatusCodeController -> About to call HttpStatusCodeService.resourceNotFound()"));

        ResponseEntity<?> response = httpStatusCodeServiceService.resourceNotFound();
        return response;
    }

    @RequestMapping("/internal-server-error")
    public ResponseEntity<?> internalServerError() {

        LOGGER.info(String.format("HttpStatusCodeController -> About to call HttpStatusCodeService.internalServerError()"));

        ResponseEntity<?> response = httpStatusCodeServiceService.internalServerError();
        return response;
    }

    @RequestMapping("/ok")
    public ResponseEntity<?> ok() {

        LOGGER.info(String.format("HttpStatusCodeController -> About to call HttpStatusCodeService.ok()"));

        ResponseEntity<?> response = httpStatusCodeServiceService.ok();
        return response;
    }

    @RequestMapping("/created")
    public ResponseEntity<?> created() {

        LOGGER.info(String.format("HttpStatusCodeController -> About to call HttpStatusCodeService.created()"));

        ResponseEntity<?> response = httpStatusCodeServiceService.created();
        return response;
    }
}
