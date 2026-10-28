package com.bank.customerservice.service;

import com.bank.customerservice.dto.request.UpdateAddressRequest;
import com.bank.customerservice.dto.response.AddressResponse;
import com.bank.customerservice.dto.response.CustomerResponse;

public interface AddressService {
	AddressResponse updateAddress(Long customerId, UpdateAddressRequest request);

	CustomerResponse getAddressById(Long addressId);
}
