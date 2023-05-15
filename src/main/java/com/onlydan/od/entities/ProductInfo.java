package com.onlydan.od.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import javax.persistence.*;

@Entity
@Slf4j
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProductInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long productId;
    @Column(precision = 10, scale = 2)
    private Double stockPrice;
    @Column
    private String productBrand;
    @Column
    private String productName;
    @Column
    private String productCondition;
    @Column
    private String productType;
    @Column
    private Integer productYear;

    @ManyToOne
    @JoinColumn(name = "country_id")
    private Countries countryId;

    @Column(length = 2000)
    private String description;
}
