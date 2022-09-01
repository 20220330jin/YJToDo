package com.example.yjtodobe.service;

import java.util.List;

import com.example.yjtodobe.model.YjBoardDto;

public interface YjBoardService {
    void create(YjBoardDto.createParam createParam);
    
    List<YjBoardDto.read> read();

    List<YjBoardDto.read> search(YjBoardDto.searchParam param);

    YjBoardDto.detailRead detailRead(YjBoardDto.detailReadParam param);

    void boardDelete(YjBoardDto.boardDeleteParam param);

    void boardUpdate(YjBoardDto.boardUpdateParam param);

    void boardAddCount(YjBoardDto.boardAddCountParam param);

}
