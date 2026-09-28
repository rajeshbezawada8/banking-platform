package com.bank.customerservice.dto.response;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.bank.customerservice.model.entity.Address;
import com.bank.customerservice.model.enums.CustomerType;
import com.bank.customerservice.model.enums.Gender;
import com.bank.customerservice.model.enums.Status;

public class CustomerResponse {
	
	private Long id;

	private String customerNumber;

	private Long userId;

	private String firstName;

	private String middleName;

	private String lastName;

	private LocalDate dateOfBirth;

	private Gender gender;

	private String email;

	private String mobileNumber;

	private CustomerType customerType;

	private Status status;

	private List<Address> addresses = new ArrayList<>();
	
	public CustomerResponse() {
		
	}

	public CustomerResponse(String customerNumber, Long userId, String firstName, String middleName, String lastName,
			LocalDate dateOfBirth, Gender gender, String email, String mobileNumber, CustomerType customerType,
			Status status, List<Address> addresses) {
		this.customerNumber = customerNumber;
		this.userId = userId;
		this.firstName = firstName;
		this.middleName = middleName;
		this.lastName = lastName;
		this.dateOfBirth = dateOfBirth;
		this.gender = gender;
		this.email = email;
		this.mobileNumber = mobileNumber;
		this.customerType = customerType;
		this.status = status;
		this.addresses = addresses;
	}

	public Long getId() {
		return id;
	}

	public String getCustomerNumber() {
		return customerNumber;
	}

	public void setCustomerNumber(String customerNumber) {
		this.customerNumber = customerNumber;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getMiddleName() {
		return middleName;
	}

	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public LocalDate getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(LocalDate dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public Gender getGender() {
		return gender;
	}

	public void setGender(Gender gender) {
		this.gender = gender;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public CustomerType getCustomerType() {
		return customerType;
	}

	public void setCustomerType(CustomerType customerType) {
		this.customerType = customerType;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public List<Address> getAddresses() {
		return addresses;
	}

	public void setAddresses(List<Address> addresses) {
		this.addresses = addresses;
	}
}
