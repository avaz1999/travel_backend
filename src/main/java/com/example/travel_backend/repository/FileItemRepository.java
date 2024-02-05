package com.example.travel_backend.repository;

import com.example.travel_backend.entity.FileItem;
import com.example.travel_backend.repository.base.BaseRepository;

public interface FileItemRepository extends BaseRepository<FileItem> {
    FileItem findByHashIdAndDeletedFalse(String hashId);

}
