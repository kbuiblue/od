package com.onlydan.od.restapi.admin;

import com.onlydan.od.dto.PaymentMethodsDTO;
import com.onlydan.od.services.PaymentMethodsService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;

@Slf4j
@RestController
@RequiredArgsConstructor
public class PaymentMethodsAdminResource implements PaymentMethodsAdminAPI {

    private final PaymentMethodsService paymentMethodsService;

    //POST
    @Override
    public ResponseEntity<PaymentMethodsDTO> createPaymentMethod(PaymentMethodsDTO paymentMethodsDTO) {
        log.info("Payment method: " + paymentMethodsDTO.getMethodName() + " created");
        PaymentMethodsDTO paymentMethodsDto = paymentMethodsService.createPaymentMethod(paymentMethodsDTO);
        return ResponseEntity.created(URI.create("/api/admin/payment-methods" + paymentMethodsDto.getPaymentMethodId())).body(paymentMethodsDto);
    }

    @Override
    public ResponseEntity<PaymentMethodsDTO> updatePaymentMethodByMethodId(Long paymentMethodId, PaymentMethodsDTO paymentMethodsDTO) {
        log.info("Payment method id #{} updated", paymentMethodId);
        PaymentMethodsDTO paymentMethodsDto = paymentMethodsService.updatePaymentMethodByMethodId(paymentMethodId, paymentMethodsDTO);
        return ResponseEntity.ok(paymentMethodsDto);
    }

    @Override
    public ResponseEntity<PaymentMethodsDTO> getPaymentMethodByMethodId(Long paymentMethodId) {
        log.info("Payment method id #{} fetched", paymentMethodId);
        return ResponseEntity.ok(paymentMethodsService.getPaymentMethodByMethodId(paymentMethodId));
    }

    @Override
    public ResponseEntity<Void> deletePaymentMethod(Long paymentMethodId) {
        log.info("Payment method id #{} deleted", paymentMethodId);
        paymentMethodsService.deletePaymentMethodByMethodId(paymentMethodId);
        return ResponseEntity.noContent().build();
    }
}
