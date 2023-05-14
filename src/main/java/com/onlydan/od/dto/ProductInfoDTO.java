package com.onlydan.od.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductInfoDTO {
    private Long productId;
    private Double stockPrice;
    private String productBrand;
    private String productName;
    private String productCondition;
    private String productType;
    private Integer productYear;
    private String countryId;
    private String description;
}
