package com.example.travel_backend.service;

import com.example.travel_backend.base.ApiResponse;
import org.springframework.core.io.FileUrlResource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;

public interface FileService {
    ApiResponse<?> upload(MultipartFile[] files, String category);
    ResponseEntity<FileUrlResource> getByHashId(String hashId,String fileName) ;
}
