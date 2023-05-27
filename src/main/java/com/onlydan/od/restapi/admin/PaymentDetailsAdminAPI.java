package com.onlydan.od.restapi.admin;

import com.onlydan.od.dto.PaymentDetailsDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RequestMapping(value = "/api/admin/payment-details")
public interface PaymentDetailsAdminAPI {

    // POST REQUESTS
    @PostMapping
    ResponseEntity<PaymentDetailsDTO> createPaymentDetail(@Valid @RequestBody PaymentDetailsDTO paymentDetailsDTO);

    // PUT REQUESTS
    @PutMapping("/{details-id}")
    ResponseEntity<PaymentDetailsDTO> updatePaymentDetailsByDetailId(@PathVariable("details-id") Long paymentDetailsId, @Valid @RequestBody PaymentDetailsDTO paymentDetailsDTO);

    // GET REQUESTS
    @GetMapping
    ResponseEntity<PaymentDetailsDTO> getPaymentDetailsByDetailId(@RequestParam("details-id") Long paymentDetailsId);

    // DELETE REQUESTS
    @DeleteMapping
    ResponseEntity<Void> deletePaymentDetailsByDetailId(@RequestParam("details-id") Long paymentDetailsId);

}
