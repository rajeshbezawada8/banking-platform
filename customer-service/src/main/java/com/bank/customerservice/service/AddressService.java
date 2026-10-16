package com.bank.customerservice.service;

import com.bank.customerservice.dto.request.UpdateAddressRequest;
import com.bank.customerservice.dto.response.AddressResponse;

public interface AddressService {
	AddressResponse updateAddress(Long CustomerId, UpdateAddressRequest request);
}
