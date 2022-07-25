package com.example.yjtodobe.service;

import com.example.yjtodobe.model.MainDashBoardDto;
import com.example.yjtodobe.repository.MainDashBoardRepositoryManager;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class MainDashBoardServiceImpl implements MainDashBoardService {

    final MainDashBoardRepositoryManager mainDashBoardRepositoryManager;

    @Override
    public void create(MainDashBoardDto.createParam createParam) {
        // 파라미터로 받은 값이 비어있는지 체크하여 비어있지 않을때만 manager로 보내 db에 저장
        if(!createParam.getContent().equals(null)){

            // db에 저장할 data 전달
            mainDashBoardRepositoryManager.create(createParam);
        }

    }
}
