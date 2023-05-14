package com.onlydan.od.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ShippingStatusesDTO {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long shippingStatusId;

    @Column
    private String statusName;
}
