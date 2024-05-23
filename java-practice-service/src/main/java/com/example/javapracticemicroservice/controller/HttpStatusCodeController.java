package com.example.javapracticemicroservice.controller;

import jakarta.ws.rs.BadRequestException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/java/http-status")
public class HttpStatusCodeController {

    @RequestMapping("/bad-request")
    ResponseEntity<?> unableToProcess() {

        // HttpStatus 400
        ResponseEntity<?> response = new ResponseEntity("Bad Request", HttpStatus.BAD_REQUEST);
        return response;
    }

    @RequestMapping("/unauthorized")
    ResponseEntity<?> unauthorized() {

        // HttpStatus 401
        ResponseEntity<?> response = new ResponseEntity("Unauthorized", HttpStatus.UNAUTHORIZED);
        return response;
    }

    @RequestMapping("/forbidden")
    ResponseEntity<?> forbidden() {

        // HttpStatus 403
        ResponseEntity<?> response = new ResponseEntity("Forbidden", HttpStatus.FORBIDDEN);
        return response;
    }

    @RequestMapping("/resource-not-found")
    ResponseEntity<?> notFound() {

        // HttpStatus 404
        ResponseEntity<?> response = new ResponseEntity("Resource not found", HttpStatus.NOT_FOUND);
        return response;
    }

    @RequestMapping("/internal-server-error")
    ResponseEntity<?> internalServerError() {

        // HttpStatus 500
        ResponseEntity<?> response = new ResponseEntity("Internal Server Error", HttpStatus.INTERNAL_SERVER_ERROR);
        return response;
    }

    @RequestMapping("/ok")
    ResponseEntity<?> ok() {

        // HttpStatus 200
        ResponseEntity<?> response = new ResponseEntity("OK", HttpStatus.OK);
        return response;
    }

    @RequestMapping("/created")
    ResponseEntity<?> created() {

        // HttpStatus 201
        ResponseEntity<?> response = new ResponseEntity("Created", HttpStatus.CREATED);
        return response;
    }
}
