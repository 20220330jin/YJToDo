package com.example.yjtodobe.repository;

import com.example.yjtodobe.domain.ImageFile;
import com.example.yjtodobe.model.ImageFileDto;

public interface ImageFileRepositoryManager {
    void boardDelete(ImageFileDto.boardDeleteParam deleteParam);
}
