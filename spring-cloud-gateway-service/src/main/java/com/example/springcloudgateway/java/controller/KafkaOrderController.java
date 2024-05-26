package com.example.springcloudgateway.java.controller;

import com.example.springcloudgateway.java.dto.Order;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/java/kafka")
public class KafkaOrderController {

    private static final Logger LOGGER = LoggerFactory.getLogger(KafkaOrderController.class);

    RestTemplate restTemplate;

    public KafkaOrderController(RestTemplate restTemplate) {

        this.restTemplate = restTemplate;
    }

    @PostMapping("/orders")
    public ResponseEntity<?> placeOrder(@RequestBody Order order) {

        Order o = order;

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        HttpEntity entity = new HttpEntity(o, headers);

        LOGGER.info(String.format("KafkaOrderController -> About to call /orders in kafka microservice"));

        ResponseEntity<?> response = restTemplate.exchange("http://localhost:8085/java/kafka/orders", HttpMethod.POST, entity, String.class);

        return response;

    }
}