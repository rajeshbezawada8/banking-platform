package com.bank.customerservice.service.implementation;

import org.springframework.transaction.annotation.Transactional;

import com.bank.customerservice.dto.request.UpdateAddressRequest;
import com.bank.customerservice.dto.response.AddressResponse;
import com.bank.customerservice.dto.response.CustomerResponse;
import com.bank.customerservice.exception.AddressNotFound;
import com.bank.customerservice.exception.CustomerNotFoundException;
import com.bank.customerservice.mapper.AddressMapper;
import com.bank.customerservice.mapper.CustomerMapper;
import com.bank.customerservice.model.entity.Address;
import com.bank.customerservice.model.entity.Customer;
import com.bank.customerservice.repository.AddressRepository;
import com.bank.customerservice.repository.CustomerRepository;
import com.bank.customerservice.service.AddressService;

public class AddressServiceImpl implements AddressService {

	private final AddressRepository addressRepository;
	private final CustomerRepository customeryRepository;
	private final AddressMapper addressMapper;
	private final CustomerMapper customerMapper;

	public AddressServiceImpl(AddressRepository addressRepository, CustomerRepository customerRepository,
			AddressMapper addressMapper, CustomerMapper customerMapper) {
		this.addressRepository = addressRepository;
		this.customeryRepository = customerRepository;
		this.addressMapper = addressMapper;
		this.customerMapper = customerMapper;
	}

	@Override
	@Transactional
	public AddressResponse updateAddress(Long customerId, UpdateAddressRequest request) {

		Customer customer = customeryRepository.findById(customerId)
				.orElseThrow(() -> new CustomerNotFoundException("Customer not found with Id: " + customerId));

		Address save = addressRepository.save(addressMapper.toEntity(customer, request));

		return addressMapper.toDTO(save);
	}

	@Override
	@Transactional(readOnly = true)
	public CustomerResponse getAddressById(Long addressId) {

		Address address = addressRepository.findById(addressId)
				.orElseThrow(() -> new AddressNotFound("Address not found with" + addressId));

		return customerMapper.toDTO(address.getCustomer());

	}

}
