package com.onlydan.od.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderDetailsDTO {

    private Long orderDetailsId;

    private Long productId;

    private Long orderId;

    private Double productPrice;

    private Boolean isOnSale;

    private Double salePercentage;

    private Integer productQuantity;

    private LocalDate orderDate;
}
