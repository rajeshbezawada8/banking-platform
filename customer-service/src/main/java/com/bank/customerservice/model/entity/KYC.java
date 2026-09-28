package com.bank.customerservice.model.entity;

import java.time.LocalDateTime;

import com.bank.customerservice.model.enums.KycLevel;
import com.bank.customerservice.model.enums.RiskCategory;
import com.bank.customerservice.model.enums.VerificationStatus;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "KYC_records")
public class KYC extends AuditableEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "kyc_id")
	private Long id;

	@OneToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "customer_id", nullable = false, unique = true)
	private Customer customer;

	@Enumerated(EnumType.STRING)
	@Column(name = "kyc_level", nullable = false)
	private KycLevel kycLevel;

	@Enumerated(EnumType.STRING)
	@Column(name = "verification_status")
	private VerificationStatus verificationStatus;

	@Column(name = "verification_method", length = 50)
	private String verificationMethod;

	@Enumerated(EnumType.STRING)
	@Column(name = "risk_category", nullable = false)
	private RiskCategory riskCategory;

	@Column(name = "verified_at")
	private LocalDateTime verifiedAt;

	@Column(name = "verified_by")
	private Long verifiedBy;

	@Column(name = "rejection_reason",length = 500)
	private String rejectionReason;

	public KYC() {

	}

	public KYC(Customer customer, KycLevel kycLevel, VerificationStatus verificationStatus, String verificationMethod,
			RiskCategory riskCategory, LocalDateTime verifiedAt, Long verifiedBy, String rejectionReason) {
		this.customer = customer;
		this.kycLevel = kycLevel;
		this.verificationStatus = verificationStatus;
		this.verificationMethod = verificationMethod;
		this.riskCategory = riskCategory;
		this.verifiedAt = verifiedAt;
		this.verifiedBy = verifiedBy;
		this.rejectionReason = rejectionReason;
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

	public KycLevel getKycLevel() {
		return kycLevel;
	}

	public void setKycLevel(KycLevel kycLevel) {
		this.kycLevel = kycLevel;
	}

	public VerificationStatus getVerificationStatus() {
		return verificationStatus;
	}

	public void setVerificationStatus(VerificationStatus verificationStatus) {
		this.verificationStatus = verificationStatus;
	}

	public String getVerificationMethod() {
		return verificationMethod;
	}

	public void setVerificationMethod(String verificationMethod) {
		this.verificationMethod = verificationMethod;
	}

	public RiskCategory getRiskCategory() {
		return riskCategory;
	}

	public void setRiskCategory(RiskCategory riskCategory) {
		this.riskCategory = riskCategory;
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

	public String getRejectionReason() {
		return rejectionReason;
	}

	public void setRejectionReason(String rejectionReason) {
		this.rejectionReason = rejectionReason;
	}

}
