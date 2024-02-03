package com.example.travel_backend.service;

import org.springframework.core.io.Resource;
import org.springframework.web.multipart.MultipartFile;

import java.nio.file.Path;
import java.util.stream.Stream;

public interface FileService {
    public void init();
    public void save(MultipartFile file);
    Resource getFileByName(String fileName);
    public void deleteAll();
    Stream<Path> loadAllFiles();
}
