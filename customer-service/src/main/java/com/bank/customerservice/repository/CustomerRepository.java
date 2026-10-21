package com.bank.customerservice.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.bank.customerservice.model.entity.Customer;
import com.bank.customerservice.model.enums.Status;

public interface CustomerRepository extends JpaRepository<Customer, Long> {

	Optional<Customer> findByCustomerNumber(String number);

	Optional<Customer> findByEmail(String email);

	Optional<Customer> findByMobileNumber(String mobileNumber);

	boolean existsByEmail(String email);

	boolean existsByMobileNumber(String mobileNumber);
	
	boolean existsByEmailAndIdNot(String email, Long id);
	
	boolean existsByMobileNumberAndIdNot(String mobileNumber, Long id);

	List<Customer> findByStatus(Status status);

	@Query("""
			    SELECT c
			    FROM Customer c
			    WHERE LOWER(c.firstName) LIKE LOWER(CONCAT('%', :keyword, '%'))
			       OR LOWER(c.lastName) LIKE LOWER(CONCAT('%', :keyword, '%'))
			""")
	List<Customer> searchByName(@Param("keyword") String keyword);
}
