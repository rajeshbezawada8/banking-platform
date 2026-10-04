package com.bank.customerservice.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import com.bank.customerservice.model.entity.Customer;
import com.bank.customerservice.model.enums.Status;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
	
	Optional<Customer> findByCustomerId(Long id);

	Optional<Customer> findByCustomerNumber(String number);

	Optional<Customer> findByEmail(String email);

	Optional<Customer> findByMobileNumber(String mobileNumber);

	boolean existsByEmail(String email);

	boolean existsByMobileNumber(String mobileNumber);

	List<Customer> findByStatus(Status status);
}
