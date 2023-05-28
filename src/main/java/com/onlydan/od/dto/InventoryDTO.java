package com.onlydan.od.dto;

import com.onlydan.od.enums.InventoryStatuses;
import com.onlydan.od.enums.ShippingStatuses;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class InventoryDTO {
    private Long inventoryId;

    private ShippingStatuses shippingStatus;

    private InventoryStatuses inventoryStatus;

    private Long productId;

    private Long stockChangeId;
}
