package com.example.yjtodobe.service;

import com.example.yjtodobe.model.MainDashBoardDto;
import com.example.yjtodobe.repository.MainDashBoardRepositoryManager;
import org.springframework.stereotype.Service;

@Service
public class MainDashBoardServiceImpl implements MainDashBoardService {

    MainDashBoardRepositoryManager mainDashBoardRepositoryManager;

    @Override
    public void create(MainDashBoardDto.createParam createParam) {
        mainDashBoardRepositoryManager.create(createParam);
    }
}
