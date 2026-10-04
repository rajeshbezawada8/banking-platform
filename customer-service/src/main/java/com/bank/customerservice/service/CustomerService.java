package com.bank.customerservice.service;

import java.util.List;

import com.bank.customerservice.dto.request.CreateCustomerRequest;
import com.bank.customerservice.dto.request.UpdateCustomerRequest;
import com.bank.customerservice.dto.response.CustomerResponse;

public interface CustomerService {

	CustomerResponse createCustomer(CreateCustomerRequest request);

	CustomerResponse getCustomerById(Long id);

	List<CustomerResponse> getAllCustomers();

	CustomerResponse updateCustomer(String userId, UpdateCustomerRequest request);

	CustomerResponse activateCustomer(String userId);

	CustomerResponse deactivateCustomer(String userId);

	void deleteCustomer(String userId);

	List<CustomerResponse> searchByName(String keyword);

	CustomerResponse searchByEmail(String email);

	CustomerResponse searchByMobile(String mobile);

	CustomerResponse getCustomerByNumber(String number);
}
