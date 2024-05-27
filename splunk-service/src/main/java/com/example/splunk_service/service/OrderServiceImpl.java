package com.example.splunk_service.service;

import com.example.splunk_service.dto.Order;
import com.example.splunk_service.util.Mapper;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@Service
public class OrderServiceImpl implements OrderService{

    Logger LOGGER = LogManager.getLogger(OrderServiceImpl.class);

    @Override
    public Order addOrder(Order order) {

        LOGGER.info("OrderServiceImpl:addOrder execution started..");
        LOGGER.info("OrderServiceImpl:addOrder request payload {} ", Mapper.mapToJsonString(order));

        order.setOrderPlacedDate(new Date());
        order.setTransactionId(UUID.randomUUID().toString());

        OrderService.orderList.add(order);
        LOGGER.info("OrderServiceImpl:addOrder response {} ", Mapper.mapToJsonString(order));
        LOGGER.info("OrderServiceImpl:addOrder execution ended..");

        return order;
    }

    @Override
    public List<Order> getOrders() {
        LOGGER.info("OrderServiceImpl:getOrders execution started..");

        List<Order> list = null;
        list = orderList;

        LOGGER.info("OrderServiceImpl:getOrders response {} ", Mapper.mapToJsonString(orderList));
        LOGGER.info("OrderService:getOrders execution ended...");

        return list;
    }

    @Override
    public Order getOrder(int id) {
        LOGGER.info("OrderService:getOrder execution started...");

        Order order = orderList.stream()
                .filter(ord -> ord.getId() == id)
                .findAny().orElseThrow(() -> new RuntimeException("Order not found with id: " + id));
        LOGGER.info("OrderService:getOrder execution ended...");
        return order;
    }
}
