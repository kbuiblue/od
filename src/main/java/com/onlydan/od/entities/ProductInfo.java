package com.onlydan.od.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProductInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long productId;
    @Column
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
