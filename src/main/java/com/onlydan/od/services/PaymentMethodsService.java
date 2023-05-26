package com.onlydan.od.services;

import com.onlydan.od.dto.PaymentMethodsDTO;
import com.onlydan.od.repositories.PaymentMethodsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class PaymentMethodsService {
    private final PaymentMethodsRepository paymentMethodsRepository;

//    //POST REQUESTS
//    public PaymentMethodsDTO createPaymentMethod(PaymentMethodsDTO paymentMethodsDTO) {
//        PaymentMethods
//    }
}
