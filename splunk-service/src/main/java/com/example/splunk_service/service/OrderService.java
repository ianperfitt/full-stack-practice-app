package com.example.splunk_service.service;

import com.example.splunk_service.dto.Order;

import java.util.ArrayList;
import java.util.List;

public interface OrderService {

    List<Order> orderList = new ArrayList<Order>();

    public Order addOrder(Order order);

    public List<Order> getOrders();

    public Order getOrder(int id);
}
