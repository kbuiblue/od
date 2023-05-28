package com.onlydan.od.entities;

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
public class OrderDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long orderDetailId;

    @OneToOne
    @JoinColumn(name = "order_id")
    private Orders orderId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "product_id")
    private ProductInfo productId;

    @Column(precision = 10, scale = 2)
    private Double productPrice;

    @Column
    private Boolean isOnSale;

    @Column
    private Double salePercentage;

    @Column
    private Integer productQuantity;

    @Column
    private LocalDate orderDate;
}
