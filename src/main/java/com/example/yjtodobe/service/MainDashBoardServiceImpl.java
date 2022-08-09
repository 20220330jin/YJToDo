package com.example.yjtodobe.service;

import com.example.yjtodobe.domain.CustomCode;
import com.example.yjtodobe.exception.HJException;
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

    @Override
    public void deleteMainDashboard(MainDashBoardDto.deleteParam param) {
        if(param.getMainDashboardId() == 0L){
            throw new HJException(CustomCode.NOID, "no");
        }
        Long mainDashboardId = param.getMainDashboardId();

        mainDashBoardRepositoryManager.deleteMainDashboard(mainDashboardId);
    }
}
