package com.example.travel_backend.controller;

import com.example.travel_backend.base.ApiResponse;
import com.example.travel_backend.service.FileService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.FileNotFoundException;

@RestController
@RequestMapping("api/file")
public class FileController {
    private final FileService service;

    public FileController(FileService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<?> upload(
            @RequestParam("files")MultipartFile[] files,
            @RequestParam String category){
        return ApiResponse.controller(service.upload(files,category));
    }

    @GetMapping("photo/{hashId}")
    public ResponseEntity<?> getByHashId(@PathVariable String hashId) {
        return service.getByHashId(hashId,"photo");
    }
}
