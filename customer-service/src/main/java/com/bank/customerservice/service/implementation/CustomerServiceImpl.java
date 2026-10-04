package com.bank.customerservice.service.implementation;

import com.bank.customerservice.mapper.CustomerMapper;
import java.util.List;

import org.springframework.stereotype.Service;

import com.bank.customerservice.dto.request.CreateCustomerRequest;
import com.bank.customerservice.dto.request.UpdateCustomerRequest;
import com.bank.customerservice.dto.response.CustomerResponse;
import com.bank.customerservice.exception.CustomerAlreadyExistsException;
import com.bank.customerservice.model.entity.Customer;
import com.bank.customerservice.repository.CustomerRepository;
import com.bank.customerservice.service.CustomerService;

@Service
public class CustomerServiceImpl implements CustomerService {

	private final CustomerMapper customerMapper;
	private final CustomerRepository customerRepository;

	public CustomerServiceImpl(CustomerRepository customerRepository, CustomerMapper customerMapper) {
		this.customerRepository = customerRepository;
		this.customerMapper = customerMapper;
	}

	@Override
	public CustomerResponse createCustomer(CreateCustomerRequest request) {
		customerValidation(request);
		
		
		return null;
	}

	@Override
	public CustomerResponse getCustomerById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<CustomerResponse> getAllCustomers() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CustomerResponse updateCustomer(String userId, UpdateCustomerRequest request) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CustomerResponse activateCustomer(String userId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CustomerResponse deactivateCustomer(String userId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteCustomer(String userId) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<CustomerResponse> searchByName(String keyword) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CustomerResponse searchByEmail(String email) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CustomerResponse searchByMobile(String mobile) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CustomerResponse getCustomerByNumber(String number) {
		// TODO Auto-generated method stub
		return null;
	}

	void customerValidation(CreateCustomerRequest request) {

		if (customerRepository.existsByEmail(request.getEmail())) {
			throw new CustomerAlreadyExistsException("Email already exists" + request.getEmail());
		}

		if (customerRepository.existsByMobileNumber(request.getMobileNumber())) {
			throw new CustomerAlreadyExistsException("Phone already exists" + request.getMobileNumber());
		}
	}
}
