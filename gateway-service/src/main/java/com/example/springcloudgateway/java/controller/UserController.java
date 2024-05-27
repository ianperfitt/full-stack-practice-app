package com.example.springcloudgateway.java.controller;

import com.example.springcloudgateway.java.dto.RestTemplateDto;
import com.example.springcloudgateway.java.entity.User;
import com.example.springcloudgateway.java.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/java")
public class UserController {

    private UserService userService;

    @Autowired
    UserController(UserService userService) {

        this.userService = userService;
    }

    @RequestMapping("/createuser/{firstName}/{lastName}")
    ResponseEntity<?> addUser(@PathVariable("firstName") String firstName, @PathVariable("lastName") String lastName) {

        User u = new User(firstName, lastName);
        User savedU = userService.createUser(u);
        ResponseEntity<?> re = new ResponseEntity(u, HttpStatus.CREATED);
        return re;
    }

    @RequestMapping("/deleteian")
    ResponseEntity<?> addUser() {

        userService.deleteUser();
        ResponseEntity<?> re = new ResponseEntity("Ian has been deleted !", HttpStatus.OK);
        return re;
    }

    @GetMapping("/resttemplate")
    ResponseEntity<?> restTemplate() {

        RestTemplateDto dto = userService.resttemplate();

        ResponseEntity<?> re = new ResponseEntity(dto, HttpStatus.OK);
        return re;
    }

    @GetMapping("/rest-template-exchange")
    ResponseEntity<?> resttemplateExchange() {

        RestTemplateDto dto = userService.resttemplateExchange();

        ResponseEntity<?> re = new ResponseEntity(dto, HttpStatus.OK);
        return re;
    }
}
