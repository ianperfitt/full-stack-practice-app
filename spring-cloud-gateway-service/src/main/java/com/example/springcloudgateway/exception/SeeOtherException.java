package com.example.springcloudgateway.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

// Esception handeling using @ResponseStatus
@ResponseStatus(value= HttpStatus.SEE_OTHER, reason="See Other !")
public class SeeOtherException extends RuntimeException {
}
