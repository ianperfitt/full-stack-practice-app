package com.example.kafka_order_service.controller;

import com.example.kafka_base_domains.OrderEvent;
import com.example.kafka_base_domains.dto.Order;
import com.example.kafka_order_service.kafka.OrderProducer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("java/kafka")
public class OrderController {

    private static final Logger LOGGER = LoggerFactory.getLogger(OrderController.class);

    private OrderProducer orderProducer;

    public OrderController(OrderProducer orderProducer) {

        this.orderProducer = orderProducer;
    }

    @PostMapping("/orders")
    public ResponseEntity<?> placeOrder(@RequestBody Order order) {

        order.setOrderId(UUID.randomUUID().toString());
        OrderEvent orderEvent = new OrderEvent();
        orderEvent.setStatus("PENDING");
        orderEvent.setMessage("order status is in pending state");
        orderEvent.setOrder(order);

        LOGGER.info(String.format("OrderController -> Sending order to Kafka producer"));

        orderProducer.sendMessage(orderEvent);

        ResponseEntity<?> response = new ResponseEntity("Order placed successfully",HttpStatus.CREATED);

        return response;

    }
}