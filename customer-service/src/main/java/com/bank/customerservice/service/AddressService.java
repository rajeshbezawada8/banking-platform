package com.bank.customerservice.service;

import com.bank.customerservice.dto.request.CreateAddressRequest;
import com.bank.customerservice.dto.response.AddressResponse;

public interface AddressService {
	AddressResponse createAddress(CreateAddressRequest addressRequest);
}
