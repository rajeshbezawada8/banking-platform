package com.bank.customerservice.storage;

import java.io.IOException;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import software.amazon.awssdk.core.ResponseBytes;
import software.amazon.awssdk.core.sync.RequestBody;
import software.amazon.awssdk.services.s3.S3Client;
import software.amazon.awssdk.services.s3.model.DeleteObjectRequest;
import software.amazon.awssdk.services.s3.model.GetObjectRequest;
import software.amazon.awssdk.services.s3.model.GetObjectResponse;
import software.amazon.awssdk.services.s3.model.PutObjectRequest;
import software.amazon.awssdk.services.s3.model.S3Exception;

@Service
public class DocumentStorageService {

    private final S3Client s3Client;

    @Value("${aws.s3.bucket-name}")
    private String bucketName;

    public DocumentStorageService(S3Client s3Client) {
        this.s3Client = s3Client;
    }

    // 1. Upload Document
    public String uploadDocument(MultipartFile file) {

        try {

            // Generate unique file name
            String storageKey = generateStorageKey(file);

            // Create S3 upload request
            PutObjectRequest putObjectRequest =
                    PutObjectRequest.builder()
                            .bucket(bucketName)
                            .key(storageKey)
                            .contentType(file.getContentType())
                            .contentLength(file.getSize())
                            .build();

            // Upload file to S3
            s3Client.putObject(
                    putObjectRequest,
                    RequestBody.fromInputStream(
                            file.getInputStream(),
                            file.getSize()
                    )
            );

            // Return S3 storage key
            return storageKey;

        } catch (IOException | S3Exception e) {

            throw new RuntimeException(
                    "Failed to upload document to S3", e);
        }
    }

    // 2. Download Document
    public byte[] downloadDocument(String storageKey) {

        try {

            // Create S3 download request
            GetObjectRequest getObjectRequest =
                    GetObjectRequest.builder()
                            .bucket(bucketName)
                            .key(storageKey)
                            .build();

            // Download file from S3
            ResponseBytes<GetObjectResponse> objectBytes =
                    s3Client.getObjectAsBytes(getObjectRequest);

            // Return file content
            return objectBytes.asByteArray();

        } catch (S3Exception e) {

            throw new RuntimeException(
                    "Failed to download document from S3", e);
        }
    }

    // 3. Delete Document
    public void deleteDocument(String storageKey) {

        try {

            // Create S3 delete request
            DeleteObjectRequest deleteObjectRequest =
                    DeleteObjectRequest.builder()
                            .bucket(bucketName)
                            .key(storageKey)
                            .build();

            // Delete file from S3
            s3Client.deleteObject(deleteObjectRequest);

        } catch (S3Exception e) {

            throw new RuntimeException(
                    "Failed to delete document from S3", e);
        }
    }

    // 4. Generate Unique Storage Key
    private String generateStorageKey(MultipartFile file) {

        String originalFileName = file.getOriginalFilename();

        String extension = "";

        if (originalFileName != null
                && originalFileName.contains(".")) {

            extension = originalFileName.substring(
                    originalFileName.lastIndexOf(".")
            ).toLowerCase();
        }

        return "customer-documents/"
                + UUID.randomUUID()
                + extension;
    }
}