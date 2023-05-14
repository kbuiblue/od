package com.onlydan.od.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PaymentDetailsDTO {

    private AccountsDTO accountId;

    private PaymentStatusesDTO paymentStatusId;

    private PaymentMethodsDTO paymentMethodId;

    private String paymentInfo;

    private LocalDate paymentDate;
}
