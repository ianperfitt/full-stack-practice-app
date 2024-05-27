package com.example.springcloudgateway.java.service;

import com.example.springcloudgateway.java.repository.feign.clients.HttpStatusCodeFeignClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class HttpStatusCodeService {

    private static final Logger LOGGER = LoggerFactory.getLogger(HttpStatusCodeService.class);

    @Autowired
    private HttpStatusCodeFeignClient httpStatusCodeClient;

    private ResponseEntity<?> re;

    public ResponseEntity<?> badRequest() {

        LOGGER.info(String.format("HttpStatusCodeService -> Calling badRequest() method in JavaClient"));

        try {
            re = httpStatusCodeClient.badRequest();
        }
        catch (Exception e) {
            re = new ResponseEntity("Bad Request", HttpStatus.BAD_REQUEST);
        }
        return re;
    }

    public ResponseEntity<?> unauthorized() {

        LOGGER.info(String.format("HttpStatusCodeService -> Calling unauthorized() method in JavaClient"));

        try {
            re = httpStatusCodeClient.unauthorized();
        }
        catch (Exception e) {
            re = new ResponseEntity("Unauthorized", HttpStatus.UNAUTHORIZED);
        }
        return re;
    }

    public ResponseEntity<?> forbidden() {

        LOGGER.info(String.format("HttpStatusCodeService -> Calling forbidden() method in JavaClient"));

        try {
            re = httpStatusCodeClient.forbidden();
        }
        catch (Exception e) {
            re = new ResponseEntity("Forbidden", HttpStatus.FORBIDDEN);
        }
        return re;
    }

    public ResponseEntity<?> resourceNotFound() {

        LOGGER.info(String.format("HttpStatusCodeService -> Calling resourceNotFound() method in JavaClient"));

        try {
            re = httpStatusCodeClient.resourceNotFound();
        }
        catch (Exception e) {
            re = new ResponseEntity("Resource Not Found", HttpStatus.NOT_FOUND);
        }
        return re;
    }

    public ResponseEntity<?> internalServerError() {

        LOGGER.info(String.format("HttpStatusCodeService -> Calling internalServerError() method in JavaClient"));

        try {
            re = httpStatusCodeClient.internalServerError();
        }
        catch (Exception e) {
            re = new ResponseEntity("Internal Server Error", HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return re;
    }

    public ResponseEntity<?> ok() {

        LOGGER.info(String.format("HttpStatusCodeService -> Calling ok() method in JavaClient"));

        try {
            re = httpStatusCodeClient.ok();
        }
        catch (Exception e) {
            re = new ResponseEntity("OK", HttpStatus.OK);
        }
        return re;
    }

    public ResponseEntity<?> created() {

        LOGGER.info(String.format("HttpStatusCodeService -> Calling created() method in JavaClient"));

        try {
            re = httpStatusCodeClient.created();
        }
        catch (Exception e) {
            re = new ResponseEntity("Created", HttpStatus.CREATED);
        }
        return re;
    }
}
