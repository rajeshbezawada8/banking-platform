package com.bank.customerservice.service;

import com.bank.customerservice.dto.response.DocumentResponse;
import com.bank.customerservice.model.entity.Document;
import com.bank.customerservice.model.enums.DocumentType;
import org.springframework.web.multipart.MultipartFile;

import java.time.LocalDate;
import java.util.List;

public interface DocumentService {

    DocumentResponse uploadDocument(Long customerId, MultipartFile file, DocumentType documentType, String documentNumber, LocalDate issuedDate, LocalDate expiryDate);

    List<DocumentResponse> getCustomerDocuments(Long customerId);

    DocumentResponse getDocumentById(Long documentId);

    void verifyDocument(Long documentId, Long verifiedBy);

    void rejectDocument(Long documentId, String rejectionReason);

    void deleteDocument(Long documentId);
}