package com.rs.warehouse.DTO;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OrderLine {

    private String itemId;
    private Integer quantity;
    private String status;


}
