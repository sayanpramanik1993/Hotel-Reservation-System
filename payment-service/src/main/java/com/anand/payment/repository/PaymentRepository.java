package com.anand.payment.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.anand.payment.entity.Payment;

public interface PaymentRepository extends JpaRepository<Payment, Long> {}
