package com.example.springcloudgateway.controller.java;

import com.example.springcloudgateway.exception.SeeOtherException;
import jakarta.ws.rs.core.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/java")
public class JavaExceptionController {

    @RequestMapping("/exception/response-status")
    String handleExceptionUsingResponseStatusAnnotation() throws SeeOtherException {
        throw new SeeOtherException();
    }

    @RequestMapping("/exception/exception-handler-in-controller")
    String handleExceptionUsingExceptionHandlerAnnotationInController() throws ClassNotFoundException {
        throw new ClassNotFoundException();
    }

    @ResponseStatus(value= HttpStatus.BAD_REQUEST)
    @ExceptionHandler(ClassNotFoundException.class)
    String forbidden() {

        return "Forbidden !";
    }

    @RequestMapping("/exception/controller-advice")
    ResponseEntity<?> handleExceptionUsingControllerAdvice() throws NullPointerException {
        throw new NullPointerException();
    }
}
