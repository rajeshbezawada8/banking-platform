package com.bank.customerservice.exception;

public class AddressNotFound extends RuntimeException {
	
	private static final long serialVersionUID = 1L;

	public AddressNotFound(String message) {
		super(message);
	}
}
