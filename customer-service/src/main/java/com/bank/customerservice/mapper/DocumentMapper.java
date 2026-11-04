package com.bank.customerservice.mapper;

import com.bank.customerservice.dto.response.DocumentResponse;
import com.bank.customerservice.model.entity.Document;
import com.bank.customerservice.model.enums.DocumentStatus;
import org.springframework.stereotype.Component;

@Component
public class DocumentMapper {
    public DocumentResponse toDTO(Document document) {
        if (document == null) {
            return null;
        }

        DocumentResponse dto = new DocumentResponse();

        dto.setDocumentId(document.getId());
        dto.setCustomer(document.getCustomer());
        dto.setDocumentType(document.getDocumentType());
        dto.setDocumentNumber(document.getDocumentNumber());
        dto.setDocumentStatus(document.getStatus());
        dto.setIssueDate(document.getIssuedDate());
        dto.setExpiryDate(document.getExpiryDate());
        dto.setVerifiedDate(document.getVerifiedAt());
        dto.setVerifiedBy(document.getVerifiedBy());
        dto.setOriginalFileName(document.getOriginalFileName());
        dto.setContentType(document.getContentType());
        dto.setFileSize(document.getFileSize());

        return dto;
    }

   public Document toEntity(DocumentResponse documentResponse) {
        if (documentResponse == null) {
            return null;
        }

        Document document = new Document();

        document.setCustomer(documentResponse.getCustomer());
        document.setDocumentType(documentResponse.getDocumentType());
        document.setDocumentNumber(documentResponse.getDocumentNumber());
        document.setStatus(DocumentStatus.PENDING);
        document.setIssuedDate(documentResponse.getIssueDate());
        document.setExpiryDate(documentResponse.getExpiryDate());
        document.setOriginalFileName(documentResponse.getOriginalFileName());
        document.setContentType(documentResponse.getContentType());
        document.setFileSize(documentResponse.getFileSize());

        return document;
    }
}
