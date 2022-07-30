package com.example.yjtodobe.service;

import java.util.List;

import com.example.yjtodobe.model.YjBoardDto;

public interface YjBoardService {
    void create(YjBoardDto.createParam createParam);
    
    List<YjBoardDto.read> read();

    YjBoardDto.detailRead detailRead(YjBoardDto.detailReadParam param);
}
