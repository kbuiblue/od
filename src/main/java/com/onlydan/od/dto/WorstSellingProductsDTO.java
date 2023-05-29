package com.onlydan.od.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class WorstSellingProductsDTO {
    private String productName;
    private Integer salesAmount;
}
