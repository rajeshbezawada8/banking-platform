package com.bank.customerservice.dto.response;

import com.bank.customerservice.model.entity.Customer;
import com.bank.customerservice.model.enums.ContentType;
import com.bank.customerservice.model.enums.DocumentStatus;
import com.bank.customerservice.model.enums.DocumentType;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class DocumentResponse {
    private Long documentId;
    private Customer customer;
    private DocumentType documentType;
    private String documentNumber;
    private DocumentStatus documentStatus;
    private LocalDate issueDate;
    private LocalDate expiryDate;
    private LocalDateTime verifiedDate;
    private Long verifiedBy;
    private String originalFileName;
    private ContentType contentType;
    private Long fileSize;

    public DocumentResponse(Long documentId, Customer customer, DocumentType documentType, String documentNumber, DocumentStatus documentStatus, LocalDate issueDate, LocalDate expiryDate, LocalDateTime verifiedDate, Long verifiedBy, String originalFileName, ContentType contentType, Long fileSize) {
        this.documentId = documentId;
        this.customer = customer;
        this.documentType = documentType;
        this.documentNumber = documentNumber;
        this.documentStatus = documentStatus;
        this.issueDate = issueDate;
        this.expiryDate = expiryDate;
        this.verifiedDate = verifiedDate;
        this.verifiedBy = verifiedBy;
        this.originalFileName = originalFileName;
        this.contentType = contentType;
        this.fileSize = fileSize;
    }

    public DocumentResponse() {

    }

    public Long getDocumentId() {
        return documentId;
    }

    public void setDocumentId(Long documentId) {
        this.documentId = documentId;
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

    public DocumentStatus getDocumentStatus() {
        return documentStatus;
    }

    public void setDocumentStatus(DocumentStatus documentStatus) {
        this.documentStatus = documentStatus;
    }

    public LocalDate getIssueDate() {
        return issueDate;
    }

    public void setIssueDate(LocalDate issueDate) {
        this.issueDate = issueDate;
    }

    public LocalDate getExpiryDate() {
        return expiryDate;
    }

    public void setExpiryDate(LocalDate expiryDate) {
        this.expiryDate = expiryDate;
    }

    public LocalDateTime getVerifiedDate() {
        return verifiedDate;
    }

    public void setVerifiedDate(LocalDateTime verifiedDate) {
        this.verifiedDate = verifiedDate;
    }

    public Long getVerifiedBy() {
        return verifiedBy;
    }

    public void setVerifiedBy(Long verifiedBy) {
        this.verifiedBy = verifiedBy;
    }

    public String getOriginalFileName() {
        return originalFileName;
    }

    public void setOriginalFileName(String originalFileName) {
        this.originalFileName = originalFileName;
    }

    public ContentType getContentType() {
        return contentType;
    }

    public void setContentType(ContentType contentType) {
        this.contentType = contentType;
    }

    public Long getFileSize() {
        return fileSize;
    }

    public void setFileSize(Long fileSize) {
        this.fileSize = fileSize;
    }
}
