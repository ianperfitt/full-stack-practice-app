package com.example.springcloudgateway.java.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

// Exception handling using @ResponseStatus
@ResponseStatus(value= HttpStatus.BAD_REQUEST, reason="CustomException1 Bad Request !")
public class CustomException1 extends RuntimeException {
}
