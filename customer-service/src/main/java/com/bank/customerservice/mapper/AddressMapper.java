package com.bank.customerservice.mapper;

import java.util.List;

import org.springframework.stereotype.Component;

import com.bank.customerservice.dto.request.CreateAddressRequest;
import com.bank.customerservice.dto.response.AddressResponse;
import com.bank.customerservice.model.entity.Address;

@Component
public class AddressMapper {

	Address toEntity(CreateAddressRequest request) {

		Address address = new Address();

		address.setAddressLine1(request.getAddressLine1());
		address.setAddressLine2(request.getAddressLine2());
		address.setCity(request.getCity());
		address.setState(request.getState());
		address.setPostalCode(request.getPostalCode());
		address.setCountry(request.getCountry());
		address.setAddressType(request.getAddressType());
		address.setPrimaryAddress(request.getPrimaryAddress());

		return address;
	}

	AddressResponse toDTO(Address address) {

		AddressResponse response = new AddressResponse();

		response.setAddressLine1(address.getAddressLine1());
		response.setAddressLine2(address.getAddressLine2());
		response.setCity(address.getCity());
		response.setState(address.getState());
		response.setPostalCode(address.getPostalCode());
		response.setCountry(address.getCountry());
		response.setAddressType(address.getAddressType());
		response.setPrimaryAddress(address.isPrimaryAddress());

		return response;
	}

	public List<AddressResponse> toDTO(List<Address> addresses) {

		return addresses.stream().map(this::toDTO).toList();
	}
}
