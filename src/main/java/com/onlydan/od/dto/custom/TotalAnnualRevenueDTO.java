package com.onlydan.od.dto.custom;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TotalAnnualRevenueDTO {
    private Integer businessYear;
    private Double totalAnnualRevenue;
}
