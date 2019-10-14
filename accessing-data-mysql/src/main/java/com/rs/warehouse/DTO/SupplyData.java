package com.rs.warehouse.DTO;

import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class SupplyData {

    private String itemId;
    private Integer quantity;
    private String QuantityAdjustmentType;
    private String locationId;


}
