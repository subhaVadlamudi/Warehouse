package com.rs.warehouse.client;


import com.rs.warehouse.DTO.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;


@Component
public class OrderClient {

    @Autowired
    RestTemplate restTemplate;

    public Order orderUpdate(Order order)
    {
        HttpEntity<Order> requestUpdate = new HttpEntity<>(order);
        ResponseEntity<Order> responseEntity = restTemplate.exchange("192.168.1.59:8084/order/api/v1/put/{id}", HttpMethod.PUT, requestUpdate, Order.class);
        return null;
    }
}
