package com.example.springcloudgateway.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

// Exception handling using @ResponseStatus
@ResponseStatus(value= HttpStatus.SEE_OTHER, reason="See Other !")
public class CustomException1 extends RuntimeException {
}
