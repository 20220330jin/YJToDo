package com.example.yjtodobe.repository;

import java.util.List;

import com.example.yjtodobe.model.YjBoardDto;

public interface YjBoardRepositorySupport {
   List<YjBoardDto.read> read();

   List<YjBoardDto.read> search(String keyword, String type);

   YjBoardDto.detailRead detailRead(YjBoardDto.detailReadParam param);


   
}
