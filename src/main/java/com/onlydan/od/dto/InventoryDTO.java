package com.onlydan.od.dto;

import com.onlydan.od.entities.InventoryStatuses;
import com.onlydan.od.entities.ShippingStatuses;
import com.onlydan.od.entities.StockChanges;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class InventoryDTO {

    private ShippingStatuses shippingStatusId;

    private InventoryStatuses inventoryStatusId;

    private StockChanges stockChangeId;
}
