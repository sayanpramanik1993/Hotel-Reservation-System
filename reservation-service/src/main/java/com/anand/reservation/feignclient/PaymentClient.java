package com.anand.reservation.feignclient;

import jakarta.ws.rs.Path;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.anand.reservation.model.Payment;

@FeignClient(name = "payment-service", path="/api/v1/payments")
public interface PaymentClient {
    @PostMapping
    Payment processPayment(Payment payment);

    @PostMapping("{paymentId}/refund")
    Payment refundPayment(@PathVariable("paymentId") Long paymentId);
}
