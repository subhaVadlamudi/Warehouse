package com.rs.warehouse.assembler;

import com.rs.warehouse.DTO.SupplyData;
import com.rs.warehouse.domain.Release;
import com.rs.warehouse.domain.ReleaseLine;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Set;


@Component
public class SupplyDataAssembler {

    public SupplyData releaseToSupplyData(Release release)
    {
        SupplyData supplyData = new SupplyData();
        supplyData.setLocationId(release.getShipFromLocationId());
        supplyData.setQuantityAdjustmentType("-");
        Set<ReleaseLine> releaseLines2 = new HashSet<>();
        for (ReleaseLine releaseLine : release.getReleaseLine()) {
            supplyData.setQuantity(releaseLine.getQuantity());
            supplyData.setItemId(releaseLine.getItemId());
        }
        return supplyData;
    }
}
