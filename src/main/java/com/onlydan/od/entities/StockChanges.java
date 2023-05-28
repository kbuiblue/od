package com.onlydan.od.entities;

import com.onlydan.od.enums.StockChangeTypes;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class StockChanges {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long stockChangeId;

    @OneToOne(mappedBy = "stockChange", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Inventory inventory;

    @Column
    private LocalDate changeDate;

    @Enumerated(EnumType.STRING)
    private StockChangeTypes changeType;

    @Column
    private Integer changeAmount;

    @Column
    private Integer remainingAmount;
}
