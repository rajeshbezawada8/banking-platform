package com.bank.customerservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bank.customerservice.dto.request.CreateAddressRequest;
import com.bank.customerservice.model.entity.Address;

public interface AddressRepository extends JpaRepository<Address, Long> {

	Address save(CreateAddressRequest addressRequest);


}
