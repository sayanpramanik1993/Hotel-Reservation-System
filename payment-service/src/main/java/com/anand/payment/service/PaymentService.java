package com.anand.payment.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.anand.payment.entity.Payment;
import com.anand.payment.repository.PaymentRepository;

@Service
public class PaymentService {
    @Autowired
    private PaymentRepository paymentRepository;

    public Payment findById(Long id) {
        return paymentRepository.findById(id).orElse(null);
    }

    public Payment save(Payment payment) {
        payment.setStatus("Received");
        return paymentRepository.save(payment);
    }

    public Payment refundPayment(Long id) {
        Payment payment = findById(id);
        payment.setStatus("Refunded");
        return paymentRepository.save(payment);
    }
}
