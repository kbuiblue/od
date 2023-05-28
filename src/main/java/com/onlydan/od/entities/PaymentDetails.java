package com.onlydan.od.entities;

import com.onlydan.od.enums.PaymentStatuses;
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
public class PaymentDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long paymentDetailsId;

    @ManyToOne
    @JoinColumn(name = "account_id")
    private Accounts account;

    @Enumerated(EnumType.STRING)
    private PaymentStatuses paymentStatus;

    @ManyToOne
    @JoinColumn(name = "payment_method_id")
    private PaymentMethods paymentMethod;

    @Column
    private LocalDate paymentDate;
}
