package com.example.springcloudgateway.controller.java;

import com.example.springcloudgateway.controller.GatewayController;
import com.example.springcloudgateway.exception.CustomException1;
import com.example.springcloudgateway.exception.CustomException2;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/java")
public class JavaExceptionController {


    private static final Logger LOGGER = LoggerFactory.getLogger(GatewayController.class);

    @RequestMapping("/exception/response-status")
    String handleExceptionUsingResponseStatusAnnotation() throws CustomException1 {

        LOGGER.info(String.format("JavaExceptionController -> throwing Exception CustomException1"));

        throw new CustomException1();
    }

    @RequestMapping("/exception/exception-handler-in-controller")
    String handleExceptionUsingExceptionHandlerAnnotationInController() throws CustomException2 {

        LOGGER.info(String.format("JavaExceptionController -> throwing Exception CustomException2"));

        throw new CustomException2();
    }

    @ResponseStatus(value= HttpStatus.BAD_REQUEST)
    @ExceptionHandler(CustomException2.class)
    String customException2() {

        LOGGER.info(String.format("JavaExceptionController -> handling Exception CustomException1 in JavaExceptionController"));

        return "CustomException2 thrown from JavaExceptionController.class !";
    }

    @RequestMapping("/exception/controller-advice")
    ResponseEntity<?> handleExceptionUsingControllerAdvice() throws NullPointerException {

        LOGGER.info(String.format("JavaExceptionController -> throwing NullPointerException to be handeled by global ExceptionHandler via ControllerAdvice"));

        throw new NullPointerException();
    }
}
