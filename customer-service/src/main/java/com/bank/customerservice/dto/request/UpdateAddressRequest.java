package com.bank.customerservice.dto.request;

import com.bank.customerservice.model.enums.AddressType;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class UpdateAddressRequest {
	@NotNull(message = "Address type is reqired")
	private AddressType addressType;

	@NotBlank(message = "Address Line 1 is required")
	private String addressLine1;

	private String addressLine2;

	@NotBlank(message = "City is required")
	private String city;

	@NotBlank(message = "State is required")
	private String state;

	@NotBlank(message = "Postal code is required")
	private String postalCode;

	@NotBlank(message = "country code is required")
	private String country;

	@NotNull(message = "Primary address is required")
	private Boolean primaryAddress;
	
	public UpdateAddressRequest() {
		
	}

	public UpdateAddressRequest(@NotNull(message = "Address type is reqired") AddressType addressType,
			@NotBlank(message = "Address Line 1 is required") String addressLine1, String addressLine2,
			@NotBlank(message = "City is required") String city, @NotBlank(message = "State is required") String state,
			@NotBlank(message = "Postal code is required") String postalCode,
			@NotBlank(message = "country code is required") String country,
			@NotNull(message = "Primary address is required") Boolean primaryAddress) {
		this.addressType = addressType;
		this.addressLine1 = addressLine1;
		this.addressLine2 = addressLine2;
		this.city = city;
		this.state = state;
		this.postalCode = postalCode;
		this.country = country;
		this.primaryAddress = primaryAddress;
	}

	public AddressType getAddressType() {
		return addressType;
	}

	public void setAddressType(AddressType addressType) {
		this.addressType = addressType;
	}

	public String getAddressLine1() {
		return addressLine1;
	}

	public void setAddressLine1(String addressLine1) {
		this.addressLine1 = addressLine1;
	}

	public String getAddressLine2() {
		return addressLine2;
	}

	public void setAddressLine2(String addressLine2) {
		this.addressLine2 = addressLine2;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getPostalCode() {
		return postalCode;
	}

	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public Boolean getPrimaryAddress() {
		return primaryAddress;
	}

	public void setPrimaryAddress(Boolean primaryAddress) {
		this.primaryAddress = primaryAddress;
	}
	
}
