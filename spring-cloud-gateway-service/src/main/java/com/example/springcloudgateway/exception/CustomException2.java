package com.example.springcloudgateway.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

// Exception handling using @ResponseStatus
@ResponseStatus(value= HttpStatus.BAD_REQUEST, reason="Custom Exception2")
public class CustomException2 extends RuntimeException {
}

