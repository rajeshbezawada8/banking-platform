package com.bank.customerservice.model.entity;

import java.time.LocalDate;
import java.time.LocalDateTime;

import com.bank.customerservice.model.enums.DocumentStatus;
import com.bank.customerservice.model.enums.DocumentType;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "customer_documents")
public class Document extends AuditableEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "document_id")
	private Long id;

	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "customer_id", nullable = false)
	private Customer customer;

	@Enumerated(EnumType.STRING)
	@Column(name = "document_type", nullable = false)
	private DocumentType documentType;

	@Column(name = "document_number", nullable = false, length = 100)
	private String documentNumber;

	@Column(name = "document_hash", length = 255)
	private String documentHash;

	@Enumerated(EnumType.STRING)
	@Column(name = "document_status", nullable = false)
	private DocumentStatus status;

	@Column(name = "issued_date", nullable = false)
	private LocalDate issuedDate;

	@Column(name = "expiry_date", nullable = false)
	private LocalDate expiryDate;

	@Column(name = "verified_at")
	private LocalDateTime verifiedAt;

	@Column(name = "verified_by")
	private Long verifiedBy;

	public Document() {

	}

	public Document(Customer customer, DocumentType documentType, String documentNumber, String documentHash,
			DocumentStatus status, LocalDate issuedDate, LocalDate expiryDate, LocalDateTime verifiedAt,
			Long verifiedBy) {
		this.customer = customer;
		this.documentType = documentType;
		this.documentNumber = documentNumber;
		this.documentHash = documentHash;
		this.status = status;
		this.issuedDate = issuedDate;
		this.expiryDate = expiryDate;
		this.verifiedAt = verifiedAt;
		this.verifiedBy = verifiedBy;
	}

	public Long getId() {
		return id;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public DocumentType getDocumentType() {
		return documentType;
	}

	public void setDocumentType(DocumentType documentType) {
		this.documentType = documentType;
	}

	public String getDocumentNumber() {
		return documentNumber;
	}

	public void setDocumentNumber(String documentNumber) {
		this.documentNumber = documentNumber;
	}

	public String getDocumentHash() {
		return documentHash;
	}

	public void setDocumentHash(String documentHash) {
		this.documentHash = documentHash;
	}

	public DocumentStatus getStatus() {
		return status;
	}

	public void setStatus(DocumentStatus status) {
		this.status = status;
	}

	public LocalDate getIssuedDate() {
		return issuedDate;
	}

	public void setIssuedDate(LocalDate issuedDate) {
		this.issuedDate = issuedDate;
	}

	public LocalDate getExpiryDate() {
		return expiryDate;
	}

	public void setExpiryDate(LocalDate expiryDate) {
		this.expiryDate = expiryDate;
	}

	public LocalDateTime getVerifiedAt() {
		return verifiedAt;
	}

	public void setVerifiedAt(LocalDateTime verifiedAt) {
		this.verifiedAt = verifiedAt;
	}

	public Long getVerifiedBy() {
		return verifiedBy;
	}

	public void setVerifiedBy(Long verifiedBy) {
		this.verifiedBy = verifiedBy;
	}
}
