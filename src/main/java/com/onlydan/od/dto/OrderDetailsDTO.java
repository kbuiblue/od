package com.onlydan.od.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderDetailsDTO {

    private OrdersDTO orderId;

    private ProductInfoDTO productId;

    private Integer productPrice;

    private Boolean isOnSale;

    private Double salePercentage;

    private Integer productQuantity;

    private LocalDate orderDate;
}
