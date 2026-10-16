package com.bank.customerservice.controller;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bank.customerservice.dto.request.CreateCustomerRequest;
import com.bank.customerservice.dto.request.UpdateCustomerRequest;
import com.bank.customerservice.dto.response.CustomerResponse;
import com.bank.customerservice.service.CustomerService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/v1/customers")
public class CustomerController {

	private final CustomerService customerService;

	public CustomerController(CustomerService customerService) {
		this.customerService = customerService;
	}

	@PostMapping
	public ResponseEntity<CustomerResponse> createCustomer(@Valid @RequestBody CreateCustomerRequest request) {

		CustomerResponse customer = customerService.createCustomer(request);

		return ResponseEntity.status(HttpStatus.CREATED).body(customer);

	}

	@PatchMapping("/{customerId}")
	public ResponseEntity<CustomerResponse> updateCustomer(@PathVariable Long customerId,
			@Valid @RequestBody UpdateCustomerRequest request) {

		CustomerResponse customer = customerService.updateCustomer(customerId, request);

		return ResponseEntity.ok(customer);
	}

	@GetMapping("/{customerId}")
	public ResponseEntity<CustomerResponse> getCustomerById(@PathVariable Long customerId) {

		CustomerResponse customer = customerService.getCustomerById(customerId);

		return ResponseEntity.ok(customer);
	}

	@GetMapping
	public ResponseEntity<Page<CustomerResponse>> getAllCustomers(Pageable pageable) {

		Page<CustomerResponse> allCustomers = customerService.getAllCustomers(pageable);

		return ResponseEntity.ok(allCustomers);
	}

	@GetMapping("/email/{email}")
	public ResponseEntity<CustomerResponse> searchByEmail(@PathVariable String email) {

		CustomerResponse searchByEmail = customerService.searchByEmail(email);

		return ResponseEntity.ok(searchByEmail);
	}

	@GetMapping("/mobile/{mobileNumber}")
	public ResponseEntity<CustomerResponse> searchByCustomerByMobile(@PathVariable String mobileNumber) {

		CustomerResponse searchByMobile = customerService.searchByMobile(mobileNumber);

		return ResponseEntity.ok(searchByMobile);
	}

	@PatchMapping("/{customerId}/activate")
	public ResponseEntity<CustomerResponse> activateCustomer(@PathVariable Long customerId) {

		CustomerResponse activateCustomer = customerService.activateCustomer(customerId);

		return ResponseEntity.ok(activateCustomer);

	}

	@PatchMapping("/{customerId}/close")
	public ResponseEntity<String> closeCustomer(@PathVariable Long customerId) {

		customerService.closeCustomer(customerId);

		return ResponseEntity.ok("Customer Successfully closed");
	}
}
