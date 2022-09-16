package com.example.yjtodobe.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.yjtodobe.domain.ImageFile;

public interface ImageFileRepository extends JpaRepository<ImageFile, Long> {
    
}
