package com.example.splunk_service.controller;

import com.example.splunk_service.dto.Order;
import com.example.splunk_service.service.OrderService;
import com.example.splunk_service.service.OrderServiceImpl;
import com.example.splunk_service.util.Mapper;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/splunk/orders")
public class SplunkController {

    Logger LOGGER = LogManager.getLogger(SplunkController.class);

    @Autowired
    private OrderService orderService;

    @PostMapping
    public Order placeOrder(@RequestBody Order order) {

        LOGGER.info("OrderController:placeOrder persist order request {}", Mapper.mapToJsonString(order));

        Order addOrder = orderService.addOrder(order);

        LOGGER.info("OrderController:placeOrder response from service {}", Mapper.mapToJsonString(addOrder));

        return addOrder;
    }

    @GetMapping
    public List<Order> getOrders() {
        List<Order> orders = orderService.getOrders();

        LOGGER.info("OrderController:placeOrders response from service {}", Mapper.mapToJsonString(orders));

        return orders;
    }

    @GetMapping("/{id}")
    public Order getOrder(@PathVariable int id) {
        LOGGER.info("OrderController:getOrder fetch order by id {}", id);

        Order order = orderService.getOrder(id);
        LOGGER.info("OrderController:getOrder fetch order by id {}", Mapper.mapToJsonString(order));
        return order;
    }
}