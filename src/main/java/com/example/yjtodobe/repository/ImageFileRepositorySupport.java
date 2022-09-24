package com.example.yjtodobe.repository;

import java.util.List;

import com.example.yjtodobe.model.ImageFileDto;

public interface ImageFileRepositorySupport {

    ImageFileDto.detailRead detailRead(ImageFileDto.detailReadParam param);

    List<ImageFileDto.read> read();
}
