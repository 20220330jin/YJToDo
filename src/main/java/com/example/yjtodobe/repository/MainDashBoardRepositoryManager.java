package com.example.yjtodobe.repository;

import com.example.yjtodobe.model.MainDashBoardDto;

public interface MainDashBoardRepositoryManager {

    /**
     * 대시보드 등록
     * @param createParam
     * @return
     */
    MainDashBoardDto.create create(MainDashBoardDto.createParam createParam);

    /**
     *
     */
    void deleteMainDashboard(Long mainDashboardId);
}
