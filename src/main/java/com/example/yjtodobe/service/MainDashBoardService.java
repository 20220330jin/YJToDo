package com.example.yjtodobe.service;

import com.example.yjtodobe.model.MainDashBoardDto;

import java.util.List;

public interface MainDashBoardService {
    /**
     *
     * @param createParam
     * @return
     */
    MainDashBoardDto.create create(MainDashBoardDto.createParam createParam);

    /**
     * DashBoard 글 전체목록 조회
     */
    List<MainDashBoardDto.list> list();

    /**
     *
     */
    void deleteMainDashboard(MainDashBoardDto.deleteParam param);

    /**
     * Dashboard 수정
     */
    void updateMainDashboard(MainDashBoardDto.updateParam param);
}
