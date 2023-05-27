package com.onlydan.od.restapi.admin;

import com.onlydan.od.dto.PaymentMethodsDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping(value = "/api/admin/payment-methods")
public interface PaymentMethodsAdminAPI {
    // POST
    @PostMapping
    ResponseEntity<PaymentMethodsDTO> createPaymentMethod(PaymentMethodsDTO paymentMethodsDTO);

    // PUT
    @PutMapping("/{payment-method-id}")
    ResponseEntity<PaymentMethodsDTO> updatePaymentMethodByMethodId(@PathVariable("method-id") Long paymentMethodId,
                                                                    @RequestBody PaymentMethodsDTO paymentMethodsDTO);

    // GET
    @GetMapping
    ResponseEntity<PaymentMethodsDTO> getPaymentMethodByMethodId(@RequestParam("method-id") Long productId);

    // DELETE
    @DeleteMapping("/{payment-method-id}")
    ResponseEntity<Void> deletePaymentMethod(@PathVariable("method-id") Long paymentMethodId);
}
