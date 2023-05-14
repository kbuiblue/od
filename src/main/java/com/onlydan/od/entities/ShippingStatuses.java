package com.onlydan.od.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ShippingStatuses {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long shippingStatusId;

    @Column
    private String statusName;
}
