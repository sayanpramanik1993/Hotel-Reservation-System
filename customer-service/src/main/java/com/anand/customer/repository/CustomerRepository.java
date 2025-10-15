package com.anand.customer.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.anand.customer.entity.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Long> {}
