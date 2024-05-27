package com.example.springcloudgateway.java.exception;

import com.example.springcloudgateway.GatewayController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class GlobalExceptionHandler {

    private static final Logger LOGGER = LoggerFactory.getLogger(GatewayController.class);

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(NullPointerException.class)
    public ResponseEntity<?> handleConflict() {

        LOGGER.info(String.format("GlobalExceptionHandler -> Handling NullPointerException via ControllerAdvice"));

        return new ResponseEntity("NullPointerException thrown from GlobalExceptionHandler.class !", HttpStatus.BAD_REQUEST);
    }
}
