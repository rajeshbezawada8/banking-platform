package com.bank.customerservice.service.implementation;

import com.bank.customerservice.dto.response.DocumentResponse;
import com.bank.customerservice.exception.CustomerNotFoundException;
import com.bank.customerservice.mapper.DocumentMapper;
import com.bank.customerservice.model.entity.Customer;
import com.bank.customerservice.model.entity.Document;
import com.bank.customerservice.model.enums.ContentType;
import com.bank.customerservice.model.enums.DocumentStatus;
import com.bank.customerservice.model.enums.DocumentType;
import com.bank.customerservice.repository.CustomerRepository;
import com.bank.customerservice.repository.DocumentRepository;
import com.bank.customerservice.service.DocumentService;
import com.bank.customerservice.storage.DocumentStorageService;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.security.MessageDigest;
import java.time.LocalDate;
import java.util.List;

@Service
public class DocumentServiceImpl implements DocumentService {
    private final DocumentMapper documentMapper;
    private final DocumentRepository documentRepository;
    private final CustomerRepository customerRepository;
    private final DocumentStorageService documentStorageService;

    public DocumentServiceImpl(DocumentMapper documentMapper, DocumentRepository documentRepository, CustomerRepository customerRepository, DocumentStorageService documentStorageService) {
        this.documentMapper = documentMapper;
        this.documentRepository = documentRepository;
        this.customerRepository = customerRepository;
        this.documentStorageService = documentStorageService;
    }

    @Override
    public DocumentResponse uploadDocument(Long customerId, MultipartFile file, DocumentType documentType, String documentNumber, LocalDate issuedDate, LocalDate expiryDate) {

        validateDocument(file, documentNumber, issuedDate, expiryDate);

        Customer customer = customerRepository.findById(customerId).orElseThrow(() -> new CustomerNotFoundException("Customer not found: " + customerId));

        String documentHash = generateDocumentHash(file);

        String storageKey = documentStorageService.uploadDocument(file);

        try {
            Document document = new Document();

            document.setCustomer(customer);
            document.setDocumentType(documentType);
            document.setDocumentNumber(documentNumber);
            document.setDocumentHash(documentHash);
            document.setStatus(DocumentStatus.PENDING);
            document.setIssuedDate(issuedDate);
            document.setExpiryDate(expiryDate);

            document.setStorageKey(storageKey);
            document.setOriginalFileName(file.getOriginalFilename());
            ContentType contentType = ContentType.fromMimeType(file.getContentType());

            document.setContentType(contentType);
            document.setFileSize(file.getSize());

            Document savedDocument = documentRepository.save(document);

            return documentMapper.toDTO(savedDocument);

        } catch (RuntimeException exception) {

            documentStorageService.deleteDocument(storageKey);

            throw exception;
        }
    }


    @Override
    public List<DocumentResponse> getCustomerDocuments(Long customerId) {
        return List.of();
    }

    @Override
    public DocumentResponse getDocumentById(Long documentId) {
        return null;
    }

    @Override
    public void verifyDocument(Long documentId, Long verifiedBy) {

    }

    @Override
    public void rejectDocument(Long documentId, String rejectionReason) {

    }

    @Override
    public void deleteDocument(Long documentId) {

    }

    private Document getDocumentEntity(Long documentId) {

        return documentRepository.findById(documentId).orElseThrow(() -> new RuntimeException("Document not found: " + documentId));
    }

    private void validateDocument(MultipartFile file, String documentNumber, LocalDate issuedDate, LocalDate expiryDate) {

        if (file == null || file.isEmpty()) {
            throw new IllegalArgumentException("Please upload a document");
        }

        if (file.getSize() > 5 * 1024 * 1024) {
            throw new IllegalArgumentException("Document size cannot exceed 5 MB");
        }

        if (documentNumber == null || documentNumber.isBlank()) {
            throw new IllegalArgumentException("Document number is required");
        }

        if (issuedDate == null || expiryDate == null) {
            throw new IllegalArgumentException("Issued date and expiry date are required");
        }

        if (expiryDate.isBefore(issuedDate)) {
            throw new IllegalArgumentException("Expiry date cannot be before issued date");
        }

        if (documentTypeIsNull()) {
            throw new IllegalArgumentException("Document type is required");
        }
    }

    private String generateDocumentHash(MultipartFile file) {

        try {

            MessageDigest digest = MessageDigest.getInstance("SHA-256");

            byte[] hash = digest.digest(file.getBytes());

            return java.util.HexFormat.of().formatHex(hash);

        } catch (Exception exception) {

            throw new RuntimeException("Failed to generate document hash", exception);
        }
    }

    private boolean documentTypeIsNull() {
        return false;
    }
}
