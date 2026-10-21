package com.bank.customerservice.mapper;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.bank.customerservice.dto.request.CreateAddressRequest;
import com.bank.customerservice.dto.request.CreateCustomerRequest;
import com.bank.customerservice.dto.response.CustomerResponse;
import com.bank.customerservice.model.entity.Address;
import com.bank.customerservice.model.entity.Customer;
import com.bank.customerservice.model.enums.Status;

@Component
public class CustomerMapper {

	private final AddressMapper addressMapper;

	public CustomerMapper(AddressMapper addressMapper) {
		this.addressMapper = addressMapper;
	}

	public Customer toEntity(CreateCustomerRequest request) {

		Customer customer = new Customer();

		customer.setFirstName(request.getFirstName());
		customer.setMiddleName(request.getMiddleName());
		customer.setLastName(request.getLastName());
		customer.setDateOfBirth(request.getDateOfBirth());
		customer.setGender(request.getGender());
		customer.setEmail(request.getEmail());
		customer.setMobileNumber(request.getMobileNumber());
		customer.setCustomerType(request.getCustomerType());
		
		customer.setStatus(Status.ACTIVE);

		List<Address> address = request.getCreateAddressRequest().stream()
				.map(CreateAddressRequest -> mapAddressToCustomer(CreateAddressRequest, customer))
				.collect(Collectors.toList());

		customer.getAddresses().addAll(address);

		return customer;
	}

	private Address mapAddressToCustomer(CreateAddressRequest createAddressRequest, Customer customer) {

		Address address = addressMapper.toEntity(createAddressRequest);
		address.setCustomer(customer);

		return address;

	}

	public CustomerResponse toDTO(Customer customer) {

		CustomerResponse response = new CustomerResponse();

		response.setCustomerNumber(customer.getCustomerNumber());
		response.setUserId(customer.getUserId());
		response.setFirstName(customer.getFirstName());
		response.setMiddleName(customer.getMiddleName());
		response.setLastName(customer.getLastName());
		response.setDateOfBirth(customer.getDateOfBirth());
		response.setGender(customer.getGender());
		response.setEmail(customer.getEmail());
		response.setMobileNumber(customer.getMobileNumber());
		response.setCustomerType(customer.getCustomerType());
		response.setAddresses(addressMapper.toDTO(customer.getAddresses()));

		return response;
	}
}
