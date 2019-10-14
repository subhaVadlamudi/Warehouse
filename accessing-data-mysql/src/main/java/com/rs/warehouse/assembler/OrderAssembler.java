package com.rs.warehouse.assembler;

import com.rs.warehouse.DTO.Order;
import com.rs.warehouse.DTO.OrderLine;
import com.rs.warehouse.domain.Release;
import com.rs.warehouse.domain.ReleaseLine;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Set;


@Component
public class OrderAssembler {

    public Order releaseToOrder(Release release)
    {

        Order order = new Order();
        Set<OrderLine> orderLines = new HashSet<>();
        OrderLine orderLine = new OrderLine();
        Set<ReleaseLine> releaseLines1 = new HashSet<>();
        for (ReleaseLine releaseLine : release.getReleaseLine()) {
            orderLine.setStatus(releaseLine.getStatus());
            orderLine.setItemId(releaseLine.getItemId());
            orderLine.setQuantity(releaseLine.getQuantity());
            orderLines.add(orderLine);
        }
        order.setOrderLine(orderLines);
        return order;
    }
}
