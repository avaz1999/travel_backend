package com.example.travel_backend.service.iml;

import com.example.travel_backend.base.ApiResponse;
import com.example.travel_backend.entity.FileItem;
import com.example.travel_backend.exception.file.*;
import com.example.travel_backend.repository.FileItemRepository;
import com.example.travel_backend.service.FileService;
import com.example.travel_backend.utils.HashIdUtil;
import com.example.travel_backend.utils.ResMessage;
import org.springframework.core.io.FileUrlResource;
import org.springframework.http.CacheControl;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.net.MalformedURLException;
import java.net.URLEncoder;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

@Service
public class FileServiceImpl implements FileService {
    private final FileItemRepository repository;
    private final HashIdUtil hashIdUtil;
    String UPLOAD_FILE_URL = "home/upload";
    Long MAX_FILE_SIZE = 4194304L;
    String COUNTRY = "country";
    String TUR_PACKET = "tur-packet";
    String TUR_PACKET_CATEGORY = "tur-packet-category";

    public FileServiceImpl(FileItemRepository repository, HashIdUtil hashIdUtil) {
        this.repository = repository;
        this.hashIdUtil = hashIdUtil;
    }

    @Override
    @Transactional
    public ApiResponse<?> upload(MultipartFile[] files, String category) {
        if (files.length == 0) throw new FileException();
        if (!(category.equals(COUNTRY) || category.equals(TUR_PACKET) || category.equals(TUR_PACKET_CATEGORY)))
            throw new FileCategoryNotFoundException();
        for (MultipartFile file : files) {
            if (file.getSize() > MAX_FILE_SIZE) throw new FileSizeException();
            String fileFormat = getExt(file.getOriginalFilename());
            if (!(fileFormat.equals("gif") || fileFormat.equals("jpg") || fileFormat.equals("png") || fileFormat.equals("jpeg") ||
                    fileFormat.equals("JPEG") || fileFormat.equals("JPG") || fileFormat.equals("HEIC")))
                throw new FileFormatException();
            File uploadFolder = new File(String.format("%s/%s", UPLOAD_FILE_URL, category));
            if (!uploadFolder.exists()) {
                if (uploadFolder.mkdirs()) {
                    System.out.println("Ushbu yol yaratildi" + uploadFolder.getPath());
                } else throw new FileSaveNotCreatedBoxException();
            }
            String generateFileId = String.format("%010d", new BigInteger(UUID.randomUUID().toString().replace("-", ""), 16));
            uploadFolder = uploadFolder.getAbsoluteFile();
            File uploadFile = new File(uploadFolder, String.format("%s.%s", generateFileId, fileFormat));
            FileItem fileItem = new FileItem();
            fileItem.setFileName(file.getOriginalFilename());
            fileItem.setFileExtension(fileFormat);
            fileItem.setHashId(hashIdUtil.encode(System.currentTimeMillis() + Thread.currentThread().getPriority()));
            fileItem.setUploadPath(uploadFolder.getPath()+ "/" + generateFileId + "." + fileFormat);
            fileItem.setFileSize(file.getSize());
            fileItem.setFileContentType(file.getContentType());
            repository.save(fileItem);
            try {
                file.transferTo(uploadFile);
            } catch (Exception e) {
                throw new FileException();
            }
        }
        return new ApiResponse<>(true, ResMessage.SUCCESS);
    }

    @Override
    public ResponseEntity<FileUrlResource> getByHashId(String hashId, String fileName) {
        FileItem fileItem = repository.findByHashIdAndDeletedFalse(hashId);
        if (fileItem != null) {
            if (fileName.isEmpty()) throw new FileException();
            try {
                String encodedFileName = URLEncoder.encode(fileItem.getFileName() + "." + fileItem.getFileExtension(), "UTF-8");
                HttpHeaders headers = new HttpHeaders();
                headers.add(HttpHeaders.CONTENT_DISPOSITION, "inline;filename=\"" + encodedFileName + "\"");
                headers.setContentType(MediaType.parseMediaType(fileItem.getFileContentType()));
                headers.setContentLength(fileItem.getFileSize());
                CacheControl cacheControl = CacheControl.maxAge(3, TimeUnit.DAYS).cachePublic();
                return ResponseEntity.ok()
                        .headers(headers)
                        .cacheControl(cacheControl)
                        .body(new FileUrlResource(fileItem.getUploadPath()));
            } catch (UnsupportedEncodingException | MalformedURLException e) {
                // Handle encoding exception
                e.printStackTrace();
            }
        }
        try {
            throw new FileNotFoundException("hashId: " + hashId);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    private String getExt(String fileName) {
        String ext = null;
        if (fileName != null && !fileName.isEmpty()) {
            int dot = fileName.lastIndexOf(".");
            if (dot > 0 && dot <= fileName.length() - 2) {
                ext = fileName.substring(dot + 1);
            }
        }
        return ext;
    }
}
