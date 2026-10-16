package com.bank.customerservice.service.implementation;

import org.springframework.transaction.annotation.Transactional;

import com.bank.customerservice.dto.request.UpdateAddressRequest;
import com.bank.customerservice.dto.response.AddressResponse;
import com.bank.customerservice.exception.CustomerNotFoundException;
import com.bank.customerservice.mapper.AddressMapper;
import com.bank.customerservice.model.entity.Address;
import com.bank.customerservice.model.entity.Customer;
import com.bank.customerservice.repository.AddressRepository;
import com.bank.customerservice.repository.CustomerRepository;
import com.bank.customerservice.service.AddressService;

public class AddressServiceImpl implements AddressService {

	private final AddressRepository addressRepository;
	private final CustomerRepository customeryRepository;
	private final AddressMapper addressMapper;

	public AddressServiceImpl(AddressRepository addressRepository, CustomerRepository customerRepository,
			AddressMapper addressMapper) {
		this.addressRepository = addressRepository;
		this.customeryRepository = customerRepository;
		this.addressMapper = addressMapper;
	}

	@Override
	@Transactional
	public AddressResponse updateAddress(Long CustomerId, UpdateAddressRequest request) {

		Customer customer = customeryRepository.findById(CustomerId)
				.orElseThrow(() -> new CustomerNotFoundException("Customer not found with Id: " + CustomerId));

		Address save = addressRepository.save(addressMapper.toEntity(customer, request));

		return addressMapper.toDTO(save);
	}

}
