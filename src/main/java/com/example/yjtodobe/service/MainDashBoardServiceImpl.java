package com.example.yjtodobe.service;

import com.example.yjtodobe.model.MainDashBoardDto;
import com.example.yjtodobe.repository.MainDashBoardRepositoryManager;
import com.example.yjtodobe.repository.MainDashBoardRepositorySupport;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class MainDashBoardServiceImpl implements MainDashBoardService {

    final MainDashBoardRepositoryManager mainDashBoardRepositoryManager;

    final MainDashBoardRepositorySupport mainDashBoardRepositorySupport;

    @Override
    public MainDashBoardDto.create create(MainDashBoardDto.createParam createParam) {
        return mainDashBoardRepositoryManager.create(createParam);
    }

    @Override
    public List<MainDashBoardDto.list> list() {
        List<MainDashBoardDto.list> boardList = mainDashBoardRepositorySupport.list();

        return boardList;
    }
}
