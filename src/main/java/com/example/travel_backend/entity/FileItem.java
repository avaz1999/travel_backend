package com.example.travel_backend.entity;

import com.example.travel_backend.base.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;

@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
public class FileItem extends BaseEntity {
    private String fileName;
    private String fileExtension;
    private Long fileSize;
    private String fileContentType;
    @Column(unique = true) private String hashId;
    private String uploadPath;
    private Boolean active;
}
