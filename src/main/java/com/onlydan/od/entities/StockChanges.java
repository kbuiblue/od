package com.onlydan.od.entities;

import com.onlydan.od.enums.StockChangeTypes;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class StockChanges {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long stockChangeId;

    @Column
    private LocalDate changeDate;

    @Enumerated(EnumType.STRING)
    private StockChangeTypes changeType;

    @Column
    private Integer changeAmount;

    @Column
    private Integer remainingAmount;
}
