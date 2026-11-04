package com.bank.customerservice.repository;

import com.bank.customerservice.model.entity.Document;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DocumentRepository extends JpaRepository<Document, Long> {
    List<Document> findByCustomerId(Long customerId);

    List<Document> findByCustomerIdAndStatus(Long customerId, String status);
}
