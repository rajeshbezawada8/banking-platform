package com.bank.customerservice.model.entity;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.bank.customerservice.model.enums.CustomerType;
import com.bank.customerservice.model.enums.Gender;
import com.bank.customerservice.model.enums.Status;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "customers")
public class Customer extends AuditableEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "customer_id")
	private Long id;

	@Column(name = "customer_number", nullable = false, unique = true, length = 20)
	private String customerNumber;

	@Column(name = "user_id", nullable = false, unique = true)
	private Long userId;

	@Column(name = "first_name", nullable = false, length = 50)
	private String firstName;

	@Column(name = "middle_name", length = 50)
	private String middleName;

	@Column(name = "last_name", nullable = false, length = 50)
	private String lastName;

	@Column(name = "date_of_birth", nullable = false)
	private LocalDate dateOfBirth;

	@Enumerated(EnumType.STRING)
	@Column(name = "gender", nullable = false)
	private Gender gender;

	@Column(name = "email", nullable = false, length = 100)
	private String email;

	@Column(name = "mobile_number", nullable = false, length = 10)
	private String mobileNumber;

	@Enumerated(EnumType.STRING)
	@Column(name = "customer_type", nullable = false)
	private CustomerType customerType;

	@Enumerated(EnumType.STRING)
	@Column(name = "status", nullable = false)
	private Status status;

	@OneToMany(mappedBy = "customer", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Address> addresses = new ArrayList<>();

	@OneToMany(mappedBy = "customer", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Document> documents = new ArrayList<>();

	@OneToOne(mappedBy = "customer", cascade = CascadeType.ALL, orphanRemoval = true)
	private KYC kyc;

	public Customer() {

	}

	public Customer(String customerNumber, Long userId, String firstName, String middleName, String lastName,
			LocalDate dateOfBirth, Gender gender, String email, String mobileNumber, CustomerType customerType,
			Status status, List<Address> addresses, List<Document> documents, KYC kyc) {
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
		this.documents = documents;
		this.kyc = kyc;
	}

	public KYC getKyc() {
		return kyc;
	}

	public void setKyc(KYC kyc) {
		this.kyc = kyc;
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

	public List<Document> getDocuments() {
		return documents;
	}

	public void setDocuments(List<Document> documents) {
		this.documents = documents;
	}

}
