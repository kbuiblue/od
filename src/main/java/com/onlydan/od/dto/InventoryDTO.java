package com.onlydan.od.dto;

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
