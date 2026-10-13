package com.bank.customerservice.dto.request;

import java.time.LocalDate;
import java.util.List;

import com.bank.customerservice.model.enums.CustomerType;
import com.bank.customerservice.model.enums.Gender;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Pattern;

public class CreateCustomerRequest {

	@NotBlank(message = "first name is required")
	private String firstName;

	private String middleName;

	@NotBlank(message = "last name is required")
	private String lastName;

	@NotNull(message = "Date of Birth is required")
	@Past(message = "Date of Birth must be a past date")
	private LocalDate dateOfBirth;

	@NotNull(message = "Gender is required")
	private Gender gender;

	@NotBlank(message = "Email address is required")
	@Email(message = "Invalid email format")
	private String email;

	@NotBlank(message = "Mobile number is required")
	@Pattern(regexp = "^[6-9][0-9]{9}$", message = "Mobile number must be a valid 10-digit Indian mobile number")
	private String mobileNumber;

	@NotNull(message = "Customer type is required")
	private CustomerType customerType;

	@NotEmpty(message = "Customer address is required")
	@Valid
	List<@NotNull CreateAddressRequest> createAddressRequest;

	public CreateCustomerRequest() {

	}

	public CreateCustomerRequest(@NotBlank(message = "first name is required") String firstName, String middleName,
			@NotBlank(message = "last name is required") String lastName,
			@NotNull(message = "Date of Birth is required") @Past(message = "Date of Birth must be a past date") LocalDate dateOfBirth,
			@NotNull(message = "Gender is required") Gender gender,
			@NotBlank(message = "Email address is required") @Email(message = "Invalid email format") String email,
			@NotBlank(message = "Mobile number is required") @Pattern(regexp = "^[6-9][0-9]{9}$", message = "Mobile number must be a valid 10-digit Indian mobile number") String mobileNumber,
			@NotNull(message = "Customer type is required") CustomerType customerType,
			@NotNull(message = "Customer address is required") @Valid List<CreateAddressRequest> createAddressRequest  ) {
		this.firstName = firstName;
		this.middleName = middleName;
		this.lastName = lastName;
		this.dateOfBirth = dateOfBirth;
		this.gender = gender;
		this.email = email;
		this.mobileNumber = mobileNumber;
		this.customerType = customerType;
		this.createAddressRequest = createAddressRequest;
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

	public List<CreateAddressRequest> getCreateAddressRequest() {
		return createAddressRequest;
	}

	public void setCreateAddressRequest(List<CreateAddressRequest> createAddressRequest) {
		this.createAddressRequest = createAddressRequest;
	}

}
