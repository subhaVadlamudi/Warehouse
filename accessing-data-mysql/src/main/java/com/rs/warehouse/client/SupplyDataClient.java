package com.rs.warehouse.client;


import com.rs.warehouse.DTO.Order;
import com.rs.warehouse.DTO.SupplyData;
import com.rs.warehouse.domain.Release;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class SupplyDataClient {

    @Autowired
    RestTemplate restTemplate;

    public SupplyData supplyDataUpdate(SupplyData supplyData)
    {
        HttpEntity<SupplyData> requestUpdate1 = new HttpEntity<>(supplyData);
        ResponseEntity<SupplyData> responseEntity1 = restTemplate.exchange("192.168.1.9:8084/put/{id}", HttpMethod.PUT, null, SupplyData.class);
        return null;
    }
}
