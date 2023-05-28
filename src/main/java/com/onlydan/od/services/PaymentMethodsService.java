package com.onlydan.od.services;

import com.onlydan.od.dto.PaymentMethodsDTO;
import com.onlydan.od.entities.PaymentMethods;
import com.onlydan.od.exceptions.AllExceptions;
import com.onlydan.od.mappers.PaymentMethodsMapper;
import com.onlydan.od.repositories.PaymentMethodsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class PaymentMethodsService {
    private final PaymentMethodsRepository paymentMethodsRepository;
    private final PaymentMethodsMapper paymentMethodsMapper;

    //POST REQUESTS
    public PaymentMethodsDTO createPaymentMethod(PaymentMethodsDTO paymentMethodsDTO) {
        if(paymentMethodsRepository.getPaymentMethodByMethodName(paymentMethodsDTO.getMethodName()).isEmpty())
            throw AllExceptions.PaymentMethodAlreadyExists();

        PaymentMethods paymentMethods = PaymentMethods.builder()
                .methodName(paymentMethodsDTO.getMethodName())
                .build();

        PaymentMethods savedPaymentMethods = paymentMethodsRepository.save(paymentMethods);

        return paymentMethodsMapper.INSTANCE.toDTO(savedPaymentMethods);
    }

    //PUT REQUESTS
    public PaymentMethodsDTO updatePaymentMethodByMethodId(Long paymentMethodId, PaymentMethodsDTO paymentMethodsDTO) {
        PaymentMethods paymentMethods = paymentMethodsRepository.findById(paymentMethodId)
                .orElseThrow(AllExceptions::PaymentMethodNotFound);

        paymentMethods.setMethodName(paymentMethodsDTO.getMethodName());

        PaymentMethods savedPaymentMethods = paymentMethodsRepository.save(paymentMethods);
        return paymentMethodsMapper.INSTANCE.toDTO(savedPaymentMethods);
    }

    //GET REQUESTS
    public PaymentMethodsDTO getPaymentMethodByMethodId(Long paymentMethodId) {
        PaymentMethods paymentMethods = paymentMethodsRepository.findById(paymentMethodId)
                .orElseThrow(AllExceptions::PaymentMethodNotFound);

        return paymentMethodsMapper.INSTANCE.toDTO(paymentMethods);
    }

    //DELETE REQUESTS
    public void deletePaymentMethodByMethodId(Long paymentMethodId) {
        paymentMethodsRepository.deleteById(paymentMethodId);
    }
}
