package com.rs.warehouse.domain;


import com.fasterxml.jackson.annotation.JsonIgnoreType;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Getter
@Setter
public class FulfillmentDetail {
    @Id

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String shipmentId;
    private String trackingNumber;
    private String packageDetailId;
    private String fulfillmentDate;
    private String itemId;
    private String fulfillmentId;
    private int quantity;
    private String status;


}
