package com.bank.customerservice.controller;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.bank.customerservice.dto.request.CreateCustomerRequest;
import com.bank.customerservice.dto.request.UpdateCustomerRequest;
import com.bank.customerservice.dto.response.CustomerResponse;
import com.bank.customerservice.service.CustomerService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Positive;

@RestController
@Validated
@RequestMapping("/api/v1/customers")
@Tag(name = "Customer Management", description = "APIs for managing customers")
public class CustomerController {

	private final CustomerService customerService;

	public CustomerController(CustomerService customerService) {
		this.customerService = customerService;
	}

	@Operation(summary = "create a customer", description = "creates a new customer")
	@ApiResponses({ @ApiResponse(responseCode = "201", description = "customer created successfully"),
			@ApiResponse(responseCode = "400", description = "Invalid customer request"),
			@ApiResponse(responseCode = "404", description = "Customer not found") })
	@PostMapping
	public ResponseEntity<CustomerResponse> createCustomer(@Valid @RequestBody CreateCustomerRequest request) {

		CustomerResponse customer = customerService.createCustomer(request);

		return ResponseEntity.status(HttpStatus.CREATED).body(customer);

	}

	@Operation(summary = "Update existing customer", description = "Update already existed customer's mobile or email address")
	@ApiResponses({ @ApiResponse(responseCode = "200", description = "update customer successfully"),
			@ApiResponse(responseCode = "400", description = "Invalid customer update request"),
			@ApiResponse(responseCode = "404", description = "Customer not found") })
	@PatchMapping("/{customerId}")
	public ResponseEntity<CustomerResponse> updateCustomer(@PathVariable @Positive Long customerId,
			@Valid @RequestBody UpdateCustomerRequest request) {

		CustomerResponse customer = customerService.updateCustomer(customerId, request);

		return ResponseEntity.ok(customer);
	}

	@GetMapping("/{customerId}")
	public ResponseEntity<CustomerResponse> getCustomerById(@PathVariable @Positive Long customerId) {

		CustomerResponse customer = customerService.getCustomerById(customerId);

		return ResponseEntity.ok(customer);
	}

	@GetMapping
	@Operation(summary = "Get all customers with pagination")
	public ResponseEntity<Page<CustomerResponse>> getAllCustomers(
			@PageableDefault(page = 20, sort = "id", direction = Direction.ASC) Pageable pageable) {

		Page<CustomerResponse> allCustomers = customerService.getAllCustomers(pageable);

		return ResponseEntity.ok(allCustomers);
	}

	@GetMapping("/search")
	@Operation(summary = "search customer", description = "search customer with mobile or email")
	public ResponseEntity<CustomerResponse> searchCustomer(@RequestParam(required = false) String email,
			@RequestParam(required = false) String mobile) {

		boolean hasEmail = email != null && !email.isBlank();
		boolean hasMobile = mobile != null && !mobile.isBlank();

		if (hasEmail == hasMobile) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Provide exactly one of email or mobile");
		}

		CustomerResponse customer = hasEmail ? customerService.searchByEmail(email.trim())
				: customerService.searchByMobile(mobile.trim());

		return ResponseEntity.ok(customer);

	}

	@PatchMapping("/{customerId}/activate")
	public ResponseEntity<CustomerResponse> activateCustomer(@PathVariable @Positive Long customerId) {

		CustomerResponse activateCustomer = customerService.activateCustomer(customerId);

		return ResponseEntity.ok(activateCustomer);

	}

	@PatchMapping("/{customerId}/close")
	public ResponseEntity<String> closeCustomer(@PathVariable @Positive Long customerId) {

		customerService.closeCustomer(customerId);

		return ResponseEntity.ok("Customer Successfully closed");
	}
}
