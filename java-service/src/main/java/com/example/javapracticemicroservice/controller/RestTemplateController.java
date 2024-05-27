package com.example.javapracticemicroservice.controller;

import com.example.javapracticemicroservice.dto.RestTemplateDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/java")
public class RestTemplateController {

    private static final Logger LOGGER = LoggerFactory.getLogger(RestTemplateController.class);

    @GetMapping("/resttemplate")
    ResponseEntity<RestTemplateDto> restTemplate() {

        LOGGER.info(String.format("RestTemplateController -> returning RestTemplateDto with message !"));

        RestTemplateDto dto = new RestTemplateDto("rest template simple example !");

        ResponseEntity<RestTemplateDto> re = new ResponseEntity<RestTemplateDto>(dto, HttpStatus.OK);
        return re;
    }

    @GetMapping("/rest-template-exchange")
    ResponseEntity<RestTemplateDto> resttemplateExchange() {

        LOGGER.info(String.format("RestTemplateController -> returning RestTemplateDto with message !"));

        RestTemplateDto dto = new RestTemplateDto("rest template exchange example !");

        ResponseEntity<RestTemplateDto> re = new ResponseEntity<RestTemplateDto>(dto, HttpStatus.OK);
        return re;
    }
}
