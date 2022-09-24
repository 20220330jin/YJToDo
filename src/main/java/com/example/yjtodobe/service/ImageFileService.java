package com.example.yjtodobe.service;

import java.util.List;

import com.example.yjtodobe.model.ImageFileDto;

public interface ImageFileService {
    ImageFileDto.detailRead detailRead(ImageFileDto.detailReadParam param);

    void boardDelete(ImageFileDto.boardDeleteParam param);

    List<ImageFileDto.read> read();
}
