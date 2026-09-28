package com.bank.customerservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bank.customerservice.model.entity.Customer;


public interface CustomerRepository extends JpaRepository<Customer, Long> {

}
