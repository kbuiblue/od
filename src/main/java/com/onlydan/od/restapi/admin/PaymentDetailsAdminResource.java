package com.onlydan.od.restapi.admin;

import com.onlydan.od.dto.PaymentDetailsDTO;
import com.onlydan.od.services.PaymentDetailsService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;

@Slf4j
@RestController
@RequiredArgsConstructor
public class PaymentDetailsAdminResource implements PaymentDetailsAdminAPI {
    public final PaymentDetailsService paymentDetailsService;

    // POST
    @Override
    public ResponseEntity<PaymentDetailsDTO> createPaymentDetail(PaymentDetailsDTO paymentDetailsDTO) {
        log.info("Payment detail #{} added", paymentDetailsDTO.getPaymentDetailId());
        PaymentDetailsDTO paymentDetailDto = paymentDetailsService.createPaymentDetail(paymentDetailsDTO);
        return ResponseEntity.created(URI.create("/api/payment-details" + paymentDetailDto.getPaymentDetailId())).body(paymentDetailDto);
    }

    // PUT
    @Override
    public ResponseEntity<PaymentDetailsDTO> updatePaymentDetailsByDetailId(Long paymentDetailsId, PaymentDetailsDTO paymentDetailsDTO) {
        log.info("Payment detail #{} updated", paymentDetailsId);
        PaymentDetailsDTO paymentDetailDto = paymentDetailsService.updatePaymentDetailsByDetailId(paymentDetailsId, paymentDetailsDTO);
        return ResponseEntity.ok(paymentDetailDto);
    }

    // GET
    @Override
    public ResponseEntity<PaymentDetailsDTO> getPaymentDetailsByDetailId(Long paymentDetailsId) {
        log.info("Payment detail #{} fetched", paymentDetailsId);
        return ResponseEntity.ok(paymentDetailsService.getPaymentDetailsByDetailId(paymentDetailsId));
    }

    // DELETE
    @Override
    public ResponseEntity<Void> deletePaymentDetailsByDetailId(Long paymentDetailsId) {
        log.info("Payment detail #{} deleted", paymentDetailsId);
        paymentDetailsService.deletePaymentDetailsByDetailId(paymentDetailsId);
        return ResponseEntity.noContent().build();
    }
}
