package com.rs.warehouse.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonIgnoreType;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;



@Entity
@Getter
@Setter
//@JsonIgnoreProperties({"fulfillmentQuantity"})
public class ReleaseLine {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String itemId;
    private Integer quantity;
    private String fulfillmentQuantity;
    private String cancelledQuantity;
    private String orderLineId;
    private String status;
    @ManyToOne()
    @JsonIgnore
    private Release release;

//    @JsonBackReference
    @OneToOne(cascade = CascadeType.ALL)
    private FulfillmentDetail fulfillmentDetail;


}
