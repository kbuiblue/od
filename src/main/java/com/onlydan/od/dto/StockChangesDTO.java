package com.onlydan.od.dto;

import com.onlydan.od.enums.StockChangeTypes;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class StockChangesDTO {
    private Long stockChangeId;

    private LocalDate changeDate;

    private StockChangeTypes changeType;

    private Integer changeAmount;

    private Integer remainingAmount;
}
