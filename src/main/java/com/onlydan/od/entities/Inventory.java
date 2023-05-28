package com.onlydan.od.entities;

import com.onlydan.od.enums.InventoryStatuses;
import com.onlydan.od.enums.ShippingStatuses;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Inventory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long inventoryId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "product_id")
    private ProductInfo productInfo;

    @Enumerated(EnumType.STRING)
    private ShippingStatuses shippingStatus;

    @Enumerated(EnumType.STRING)
    private InventoryStatuses inventoryStatus;

    @OneToOne
    @JoinColumn(name = "stock_change_id")
    private StockChanges stockChange;
}
