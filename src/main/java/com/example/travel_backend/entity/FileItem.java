package com.example.travel_backend.entity;

import com.example.travel_backend.base.BaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

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
