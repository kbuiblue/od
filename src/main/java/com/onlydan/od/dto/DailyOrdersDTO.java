package com.onlydan.od.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DailyOrdersDTO {
    private LocalDate orderDate;
    private Integer dailyOrders;
}
