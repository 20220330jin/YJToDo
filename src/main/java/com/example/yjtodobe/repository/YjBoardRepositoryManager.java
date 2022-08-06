package com.example.yjtodobe.repository;

import com.example.yjtodobe.model.YjBoardDto;

public interface YjBoardRepositoryManager {
    
    void create(YjBoardDto.createParam createParam);   
    
    void boardDelete(YjBoardDto.boardDeleteParam deleteParam);
    
    void boardUpdate(YjBoardDto.boardUpdateParam updateParam);
}
