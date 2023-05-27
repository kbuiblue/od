package com.onlydan.od.dto;

import com.onlydan.od.enums.PaymentStatuses;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PaymentDetailsDTO {
    private Long paymentDetailId;

    private Long accountId;

    private Long paymentMethodId;

    private PaymentStatuses paymentStatus;

    private LocalDate paymentDate;
}
