package com.onlydan.od.dto.custom;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DailyRevenueDTO {
    private LocalDate orderDate;
    private Double dailyRevenue;
}
