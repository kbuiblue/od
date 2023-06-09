package com.onlydan.od.services;

import com.onlydan.od.dto.PaymentDetailsDTO;
import com.onlydan.od.entities.Accounts;
import com.onlydan.od.entities.PaymentDetails;
import com.onlydan.od.entities.PaymentMethods;
import com.onlydan.od.exceptions.AllExceptions;
import com.onlydan.od.mappers.PaymentDetailsMapper;
import com.onlydan.od.repositories.PaymentDetailsRepository;
import com.onlydan.od.repositories.PaymentMethodsRepository;
import com.onlydan.od.repositories.security.AccountsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class PaymentDetailsService {
    private final PaymentDetailsRepository paymentDetailsRepository;
    private final AccountsRepository accountsRepository;
    private final PaymentMethodsRepository paymentMethodsRepository;
    private final PaymentDetailsMapper paymentMethodsMapper;


    //POST REQUESTS
    public PaymentDetailsDTO createPaymentDetail(PaymentDetailsDTO paymentDetailsDTO) {
        Accounts account = accountsRepository.findById(paymentDetailsDTO.getAccountId())
                .orElseThrow(AllExceptions::AccountNotFound);
        PaymentMethods paymentMethod = paymentMethodsRepository.findById(paymentDetailsDTO.getPaymentMethodId())
                .orElseThrow(AllExceptions::PaymentMethodNotFound);


        PaymentDetails paymentDetails = PaymentDetails.builder()
                .account(account)
                .paymentMethod(paymentMethod)
                .paymentDate(paymentDetailsDTO.getPaymentDate())
                .paymentStatus(paymentDetailsDTO.getPaymentStatus())
                .build();

        PaymentDetails savedPaymentDetails = paymentDetailsRepository.save(paymentDetails);

        return paymentMethodsMapper.INSTANCE.toDTO(savedPaymentDetails);
    }

    // PUT REQUESTS

    public PaymentDetailsDTO updatePaymentDetailsByDetailsId(Long detailsId, PaymentDetailsDTO paymentDetailsDTO) {
        Accounts account = accountsRepository.findById(paymentDetailsDTO.getAccountId())
                .orElseThrow(AllExceptions::AccountNotFound);
        PaymentMethods paymentMethod = paymentMethodsRepository.findById(paymentDetailsDTO.getPaymentMethodId())
                .orElseThrow(AllExceptions::PaymentMethodNotFound);
        PaymentDetails paymentDetails = paymentDetailsRepository.findById(detailsId)
                .orElseThrow(AllExceptions::PaymentDetailNotFound);

        paymentDetails.setAccount(account);
        paymentDetails.setPaymentMethod(paymentMethod);
        paymentDetails.setPaymentStatus(paymentDetailsDTO.getPaymentStatus());
        paymentDetails.setPaymentDate(paymentDetailsDTO.getPaymentDate());

        PaymentDetails updatedPaymentDetails = paymentDetailsRepository.save(paymentDetails);

        return paymentMethodsMapper.INSTANCE.toDTO(updatedPaymentDetails);
    }

    // GET REQUESTS
    public PaymentDetailsDTO getPaymentDetailsByDetailsId(Long detailsId) {
        PaymentDetails paymentDetails = paymentDetailsRepository.findById(detailsId)
                .orElseThrow(AllExceptions::PaymentDetailNotFound);

        return paymentMethodsMapper.INSTANCE.toDTO(paymentDetails);
    }

    // DELETE REQUESTS
    public void deletePaymentDetailsByDetailsId(Long detailsId) {
        paymentDetailsRepository.deleteById(detailsId);
    }
}
