package com.bank.customerservice.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.bank.customerservice.dto.request.CreateCustomerRequest;
import com.bank.customerservice.dto.request.UpdateCustomerRequest;
import com.bank.customerservice.dto.response.CustomerResponse;

public interface CustomerService {

	CustomerResponse createCustomer(CreateCustomerRequest request);

	CustomerResponse getCustomerById(Long id);

	Page<CustomerResponse> getAllCustomers(Pageable pageable);

	CustomerResponse updateCustomer(Long customerId, UpdateCustomerRequest request);

	CustomerResponse activateCustomer(Long customerId);

	CustomerResponse deactivateCustomer(Long customerId);

	void closeCustomer(Long customerId);

	List<CustomerResponse> searchByName(String keyword);

	CustomerResponse searchByEmail(String email);

	CustomerResponse searchByMobile(String mobile);

	CustomerResponse getCustomerByNumber(String customerNumber);
	
}