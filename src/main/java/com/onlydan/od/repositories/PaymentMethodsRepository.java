package com.onlydan.od.repositories;

import com.onlydan.od.entities.PaymentMethods;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PaymentMethodsRepository extends JpaRepository<PaymentMethods, Long> {
    Optional<PaymentMethods> getPaymentMethodByMethodName(String methodName);
}
