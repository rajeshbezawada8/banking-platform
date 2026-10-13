package com.bank.customerservice.service.implementation;

import com.bank.customerservice.dto.request.CreateAddressRequest;
import com.bank.customerservice.dto.response.AddressResponse;
import com.bank.customerservice.mapper.AddressMapper;
import com.bank.customerservice.model.entity.Address;
import com.bank.customerservice.repository.AddressRepository;
import com.bank.customerservice.service.AddressService;

public class AddressServiceImpl implements AddressService {
	private final AddressRepository addressRepository;
	private final AddressMapper addressMapper;

	public AddressServiceImpl(AddressRepository addressRepository, AddressMapper addressMapper) {
		this.addressRepository = addressRepository;
		this.addressMapper = addressMapper;
	}

	@Override
	public AddressResponse createAddress(CreateAddressRequest addressRequest) {
		Address address = addressRepository.save(addressRequest);
		return addressMapper.toDTO(address);
	}
}
