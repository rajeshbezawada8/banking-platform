package com.bank.customerservice.service.implementation;

import com.bank.customerservice.mapper.CustomerMapper;
import com.bank.customerservice.model.entity.Customer;
import com.bank.customerservice.model.enums.Status;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bank.customerservice.dto.request.CreateCustomerRequest;
import com.bank.customerservice.dto.request.UpdateCustomerRequest;
import com.bank.customerservice.dto.response.CustomerResponse;
import com.bank.customerservice.exception.CustomerAlreadyExistsException;
import com.bank.customerservice.exception.CustomerNotFoundException;
import com.bank.customerservice.repository.CustomerRepository;
import com.bank.customerservice.service.CustomerService;
import com.bank.customerservice.util.CustomerNumberGenerator;

@Service
public class CustomerServiceImpl implements CustomerService {

	private final CustomerMapper customerMapper;
	private final CustomerRepository customerRepository;

	public CustomerServiceImpl(CustomerRepository customerRepository, CustomerMapper customerMapper) {
		this.customerRepository = customerRepository;
		this.customerMapper = customerMapper;
	}

	@Transactional
	@Override
	public CustomerResponse createCustomer(CreateCustomerRequest request) {

		validateNewCustomer(request);
		Customer customer = customerMapper.toEntity(request);
		customer.setCustomerNumber(CustomerNumberGenerator.generate());
		Customer save = customerRepository.save(customer);
		return customerMapper.toDTO(save);

	}

	@Override
	public CustomerResponse getCustomerById(Long id) {

		Customer customer = customerRepository.findById(id)
				.orElseThrow(() -> new CustomerNotFoundException("Customer not found: " + id));
		return customerMapper.toDTO(customer);

	}

	@Override
	public Page<CustomerResponse> getAllCustomers(Pageable pageable) {

		return customerRepository.findAll(pageable).map(customerMapper::toDTO);

	}

	@Transactional
	@Override
	public CustomerResponse updateCustomer(Long customerId, UpdateCustomerRequest request) {

		Customer customer = customerRepository.findById(customerId)
				.orElseThrow(() -> new CustomerNotFoundException("Customer not found by ID: " + customerId));

		if (customerRepository.existsByEmailAndCustomerIdNot(request.getEmail(), customerId)) {
			throw new CustomerAlreadyExistsException("Customer already exists with email: " + request.getEmail());
		}

		if (customerRepository.existsByMobileNumberAndCustomerIdNot(request.getMobileNumber(), customerId)) {
			throw new CustomerAlreadyExistsException(
					"Customer already exists with Mobile: " + request.getMobileNumber());
		}

		customer.setEmail(request.getEmail());
		customer.setMobileNumber(request.getMobileNumber());

		Customer save = customerRepository.save(customer);

		return customerMapper.toDTO(save);
	}

	@Transactional
	@Override
	public CustomerResponse activateCustomer(Long customerId) {
		return updateCustomerStatus(customerId, Status.ACTIVE);
	}

	@Transactional
	@Override
	public CustomerResponse deactivateCustomer(Long customerId) {

		return updateCustomerStatus(customerId, Status.INACTIVE);

	}

	@Transactional
	@Override
	public void closeCustomer(Long customerId) {

		Customer customer = customerRepository.findById(customerId)
				.orElseThrow(() -> new CustomerNotFoundException("Customer not found by ID: " + customerId));
		customer.setStatus(Status.CLOSED);
		customerRepository.save(customer);

	}

	@Override
	public List<CustomerResponse> searchByName(String keyword) {

		List<Customer> searchByName = customerRepository.searchByName(keyword);
		return searchByName.stream().map(customerMapper::toDTO).collect(Collectors.toList());

	}

	@Override
	public CustomerResponse searchByEmail(String email) {

		Customer customer = customerRepository.findByEmail(email)
				.orElseThrow(() -> new CustomerNotFoundException("Customer not found with email: " + email));
		return customerMapper.toDTO(customer);

	}

	@Override
	public CustomerResponse searchByMobile(String mobile) {

		Customer customer = customerRepository.findByMobileNumber(mobile)
				.orElseThrow(() -> new CustomerNotFoundException("Customer not found with Mobile: " + mobile));
		return customerMapper.toDTO(customer);

	}

	@Override
	public CustomerResponse getCustomerByNumber(String number) {

		Customer customer = customerRepository.findByCustomerNumber(number)
				.orElseThrow(() -> new CustomerNotFoundException("Customer not found with Number: " + number));
		return customerMapper.toDTO(customer);

	}

	private void validateNewCustomer(CreateCustomerRequest request) {

		if (customerRepository.existsByEmail(request.getEmail())) {
			throw new CustomerAlreadyExistsException("Email already exists: " + request.getEmail());
		}

		if (customerRepository.existsByMobileNumber(request.getMobileNumber())) {
			throw new CustomerAlreadyExistsException("Phone already exists: " + request.getMobileNumber());
		}
	}

	private CustomerResponse updateCustomerStatus(Long customerId, Status newStatus) {

		Customer customer = customerRepository.findById(customerId)
				.orElseThrow(() -> new CustomerNotFoundException("Customer not found by ID: " + customerId));

		Status currentStatus = customer.getStatus();

		if (currentStatus == Status.CLOSED) {
			throw new IllegalStateException("Closed customer status cannot be changed");
		}

		customer.setStatus(newStatus);
		
		return customerMapper.toDTO(customerRepository.save(customer));

	}

}
