package com.example.yjtodobe.service;

import com.example.yjtodobe.model.MainDashBoardDto;

import java.util.List;

public interface MainDashBoardService {
    void create(MainDashBoardDto.createParam createParam);

    /**
     * DashBoard 글 전체목록 조회
     */
    List<MainDashBoardDto.list> list();
}
