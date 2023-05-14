package com.onlydan.od.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PaymentDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long paymentDetailId;

    @ManyToOne
    @JoinColumn(name = "account_id")
    private Accounts accountId;

    @ManyToOne
    @JoinColumn(name = "payment_status_id")
    private PaymentStatuses paymentStatusId;

    @ManyToOne
    @JoinColumn(name = "payment_method_id")
    private PaymentMethods paymentMethodId;

    @Column
    private String paymentInfo;

    @Column
    private LocalDate paymentDate;
}
