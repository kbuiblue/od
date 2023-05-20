package com.onlydan.od.dto;


import com.onlydan.od.entities.StockChanges;
import com.onlydan.od.enums.InventoryStatuses;
import com.onlydan.od.enums.ShippingStatuses;
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
